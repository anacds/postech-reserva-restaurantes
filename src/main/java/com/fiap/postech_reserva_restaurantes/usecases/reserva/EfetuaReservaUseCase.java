//package com.fiap.postech_reserva_restaurantes.usecases.reserva;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
//import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
//import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
//import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
//import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
//import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
//import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
//import com.fiap.postech_reserva_restaurantes.usecases.mesa.VerificaCapacidadeMesaUseCase;
//import com.fiap.postech_reserva_restaurantes.usecases.mesa.VerificaMesasDisponiveisPorHorario;
//
//@Service
//public class EfetuaReservaUseCase {
//
//	public static ReservaEntity reservarMesa(ReservaDTO reservaDTO) {
//		
//		MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(reservaDTO.idMesa());
//		
////		UsuarioEntity usuario = BuscarUsuarioPorIdUseCase.buscar(reservaDTO.idUsuario());
//		UsuarioEntity usuario = new UsuarioEntity();
//		
////		RestauranteEntity restaurante = BuscarRestaurantePorIdUseCase.buscar(reservaDTO.idRestaurante());
//		RestauranteEntity restaurante = new RestauranteEntity();
//		
//		ReservaEntity reserva = new ReservaEntity(
//				mesa,
//				usuario, 
//				restaurante, 
//				reservaDTO.dataHoraInicio(),
//				reservaDTO.dataHoraFim(),
//				reservaDTO.status(), 
//				reservaDTO.observacao(),
//				reservaDTO.qtdPessoas());
//
//		try {
//			// Valida se horário de reserva está dentro do horário de funcionamento do restaurante
//			validarHorarioFuncionamentoRestaurante(restaurante, reserva);
//			
//			//Valida se existem mesas disponíveis nessa restaurante nesse horário. Retorna mesas disponíveis
//			List<MesaEntity> mesasDisponiveisPorHorario = 
//					VerificaMesasDisponiveisPorHorario.verifica(restaurante.getId(), reserva.getDataHoraInicio(), reserva.getDataHoraFim());
//			
//			if (Objects.isNull(mesasDisponiveisPorHorario)) {
//				throw new Exception("Não existem mesas disponíveis nesse horário.");
//			}
//			
//			List<MesaEntity> mesasDisponiveis = VerificaCapacidadeMesaUseCase.verificar(mesasDisponiveisPorHorario, reserva.getQtdPessoas());
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//	
//	private static void validarHorarioFuncionamentoRestaurante(RestauranteEntity restaurante, ReservaEntity reserva) throws Exception {
//		for (HorarioFuncionamentoEntity horario :restaurante.getHorariosFuncionamento() ) {
//			
//			if (horario.getDiaSemana() != reserva.diaDaSemana) {
//				throw new Exception("Dia da semana de reserva inválido");
//			}
//			if (reserva.getDataHoraInicio().isBefore(horario.getHorarioAbertura())) {
//				throw new Exception("Horário de reserva inválido");
//			}
//			if (reserva.getDataHoraFim().isAfter(horario.getHorarioFechamento())) {
//				throw new Exception("Horário de reserva inválido");
//			}
//		}
//	}
//}
