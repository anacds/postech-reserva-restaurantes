package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;

@Service
public class BuscaReservasPorRestauranteUseCase {
	
	@Autowired
	public ReservaGateway reservaGateway;
	
	public List<ReservaEntity> buscar(String idRestaurante) {
		try {
			return reservaGateway.buscarReservasPorRestaurante(idRestaurante);
		} catch (Exception e) {
			System.out.println("Não existem reservas para esse restaurante");
			return null;
		}
	}

}
