package com.fiap.postech_reserva_restaurantes.usecases;

import java.time.LocalDateTime;

import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;

public class ReservaMesaUseCase {

	public static ReservaEntity reservarMesa(MesaEntity mesa, RestauranteEntity restaurante, LocalDateTime dataHoraInicio,
			LocalDateTime dataHoraFim) throws Exception {
		
		ReservaEntity reserva = new ReservaEntity(mesa, restaurante, dataHoraInicio, dataHoraFim);
		validarHorario(restaurante, reserva);
		return reserva;
	}
	
	private static void validarHorario(RestauranteEntity restaurante, ReservaEntity reserva) throws Exception {
		for (HorarioFuncionamentoEntity horario :restaurante.getHorariosFuncionamento() ) {
			
			if (horario.getDiaSemana() != reserva.diaDaSemana) {
				throw new Exception("Dia da semana inválido");
			}
			if (reserva.getDataHoraInicio().isBefore(horario.getHorarioAbertura())) {
				throw new Exception("Horário inválido");
			}
			if (reserva.getDataHoraFim().isAfter(horario.getHorarioFechamento())) {
				throw new Exception("Horário inválido");
			}
		}
	}
}
