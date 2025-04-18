package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.entities.Status;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AdicionaReservaEmMesa;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.VerificaCapacidadeMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.VerificaMesasDisponiveisPorHorario;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.BuscaRestaurantePorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.BuscarUsuarioUseCase;

@Service
public class EfetuaReservaUseCase {
	
	@Autowired
	private BuscarUsuarioUseCase buscarUsuarioUseCase;
	
	@Autowired
	private BuscaRestaurantePorIdUseCase buscarRestaurantePorId;
	
	@Autowired
	private AdicionaReservaEmMesa adicionaReservaEmMesa;
	
	@Autowired
	private ReservaGateway reservaGateway;
	
	@Autowired
	private VerificaMesasDisponiveisPorHorario verificaMesasDisponiveisPorHorario;
	
	@Autowired
	private VerificaCapacidadeMesaUseCase verificaCapacidadeMesaUseCase;
	
	public ReservaEntity reservarMesa(ReservaDTO reservaDTO) {
		
		try {
	
			Optional<UsuarioEntity> usuarioOpt = buscarUsuarioUseCase.buscarPorId(reservaDTO.idUsuario());
		
			Optional<RestauranteEntity> restauranteOpt = buscarRestaurantePorId.buscarRestaurantePorId(reservaDTO.idRestaurante());
			
			if (Objects.isNull(usuarioOpt)) {
				throw new Exception("Esse usuário não existe");
			}
			
			if (Objects.isNull(restauranteOpt)) {
				throw new Exception("Esse restaurante não existe");
			}
			
			UsuarioEntity usuario = usuarioOpt.get();
			
			RestauranteEntity restaurante = restauranteOpt.get();
			
			ReservaEntity reserva = new ReservaEntity(
					null,					//mesa
					usuario, 
					restaurante, 
					reservaDTO.dataHoraInicio(),
					reservaDTO.dataHoraFim(),
					reservaDTO.status(), 
					reservaDTO.observacao(),
					reservaDTO.qtdPessoas());

			reserva.setIdRestaurante(restaurante.getId());
			reserva.setIdUsuario(usuario.getId());
			  
			
			//Valida se existem mesas disponíveis nessa restaurante nesse horário. Retorna mesas disponíveis
			List<MesaEntity> mesasDisponiveisPorHorario = 
					verificaMesasDisponiveisPorHorario.verifica(restaurante.getId(), reserva.getDataHoraInicio(), reserva.getDataHoraFim());
			
			if (Objects.isNull(mesasDisponiveisPorHorario) || mesasDisponiveisPorHorario.isEmpty()) {
				throw new Exception("Não existem mesas disponíveis nesse horário.");
			}
			
			//valida quais mesas disponiveis por horario cumnprem com os requisitos de 
			List<MesaEntity> mesasDisponiveis = verificaCapacidadeMesaUseCase.verificar(mesasDisponiveisPorHorario, reserva.getQtdPessoas());
			
			if (Objects.isNull(mesasDisponiveis) || mesasDisponiveis.isEmpty()) {
				throw new Exception("Não existem mesas disponíveis para esse horário e capacidade.");
			}
			
			Optional<MesaEntity> mesaEscolhidaParaReserva = mesasDisponiveis.stream().findFirst();
			
			if (Objects.isNull(mesaEscolhidaParaReserva) || mesaEscolhidaParaReserva.isEmpty()) {
				throw new Exception("Não existe mesa para essa reserva");
			}
			
			reserva.setMesa(mesaEscolhidaParaReserva.get());
			reserva.setIdMesa(mesaEscolhidaParaReserva.get().getId());
			reserva.setStatus(Status.EM_ESPERA);
			
			
			reservaGateway.criarReserva(reserva);
			adicionaReservaEmMesa.adicionaReservaEmMesa(reserva, reserva.getIdMesa());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
}
