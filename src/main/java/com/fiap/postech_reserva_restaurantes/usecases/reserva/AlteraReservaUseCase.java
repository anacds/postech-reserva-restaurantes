package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.BuscaRestaurantePorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.BuscarUsuarioUseCase;

@Service
public class AlteraReservaUseCase {
	
	@Autowired
	public ReservaGateway reservaGateway;
	
	@Autowired
	private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
	
	@Autowired
	private BuscarUsuarioUseCase buscarUsuarioUseCase;
	
	@Autowired
	private BuscaRestaurantePorIdUseCase buscaRestaurantePorIdUseCase;
	
	public ReservaEntity alterar(ReservaDTO reservaDTO) {
		
		try {
			
			MesaEntity mesa = buscarMesaPorIdUseCase.buscar(reservaDTO.idMesa());
			
			Optional<UsuarioEntity> usuario = buscarUsuarioUseCase.buscarPorId(reservaDTO.idUsuario());
			
			Optional<RestauranteEntity> restaurante =  buscaRestaurantePorIdUseCase.buscarRestaurantePorId(reservaDTO.idRestaurante());
			
			ReservaEntity reserva = new ReservaEntity(
					mesa,
					usuario.get(), 
					restaurante.get(), 
					reservaDTO.dataHoraInicio(), 
					reservaDTO.dataHoraFim(), 
					reservaDTO.status(),
					reservaDTO.observacao(), 
					reservaDTO.qtdPessoas());
			
			reserva.setId(reservaDTO.id());
			
			return reservaGateway.alterarReserva(reserva);
		} catch (Exception e) {
			System.out.println("");
			return null;
		}
	}

}
