package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.Status;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;

@Service
public class CancelaReservaUseCase {

	@Autowired
	public static ReservaGateway reservaGateway;
	
	public static ReservaEntity cancelar(String idReserva) {
		ReservaEntity reserva = BuscaReservaPorIdUseCase.buscar(idReserva);
		reserva.setStatus(Status.CANCELADA);
		
		ReservaDTO reservaDTO = new ReservaDTO(idReserva, idReserva, idReserva, null, null, idReserva, idReserva, 0);
		
		ReservaEntity reservaAlterada = AlteraReservaUseCase.alterar(reservaDTO);
		
		return reservaAlterada;
	}

}
