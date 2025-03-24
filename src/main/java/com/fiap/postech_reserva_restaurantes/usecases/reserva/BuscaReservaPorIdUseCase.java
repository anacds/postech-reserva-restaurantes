package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;

@Service
public class BuscaReservaPorIdUseCase {

	@Autowired
	public ReservaGateway reservaGateway;
	
	public ReservaEntity buscar(String id) {
		try {
			return reservaGateway.buscaReservaPorId(id);
		} catch (Exception e) {
			System.out.println("Reserva com esse id não existe.");
			return null;
		}
	}

}
