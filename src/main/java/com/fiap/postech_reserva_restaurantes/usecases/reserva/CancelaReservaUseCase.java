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
	public ReservaGateway reservaGateway;
	
	@Autowired
	public BuscaReservaPorIdUseCase buscarReservaPorIdUseCase;
	
	@Autowired
	public AlteraReservaUseCase alteraReservaUseCase;
	
	public ReservaEntity cancelar(String idReserva) {
		
		ReservaEntity reserva = buscarReservaPorIdUseCase.buscar(idReserva);
		
		reserva.setStatus(Status.CANCELADA);
		
		ReservaDTO reservaDTO = new ReservaDTO(reserva.getId(), reserva.getUsuario().getId(), reserva.getRestaurante().getId(), 
				reserva.getDataHoraInicio(), reserva.getDataHoraFim(), reserva.getStatus(), reserva.getObservacao(), reserva.getQtdPessoas());
		
		ReservaEntity reservaAlterada = alteraReservaUseCase.alterar(reservaDTO);
		
		return reservaAlterada;
	}

}
