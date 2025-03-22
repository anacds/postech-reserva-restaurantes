package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;

@Service
public class EfetuaReservaUseCase {

	public static ReservaEntity reservarMesa(ReservaDTO reservaDTO) {
		
		MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(reservaDTO.idMesa());
		
		//fazer o mesmo com usuario 
		
		//fazer o mesmo com restaurante
	
//		ReservaEntity reserva = new ReservaEntity(mesa, usuario, restaurante, dataHoraInicio, dataHoraFim, status, observacao, qtdPessoas);
		
		try {
//			validarHorario(restaurante, reser va);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		return reserva;
		return null;
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
