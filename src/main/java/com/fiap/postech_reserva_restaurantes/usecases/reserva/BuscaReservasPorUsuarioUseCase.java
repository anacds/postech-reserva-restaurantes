package com.fiap.postech_reserva_restaurantes.usecases.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.ReservaGateway;

@Service
public class BuscaReservasPorUsuarioUseCase {
	
	@Autowired
	public static ReservaGateway reservaGateway;
	
	public static List<ReservaEntity> buscar(String idUsuario) {
		try {
			return reservaGateway.buscarReservasPorUsuario(idUsuario);
			
		} catch (Exception e) {
			System.out.println("Não existe reserva cadastrada para esse usuário");
			return null;
		}
	}

}
