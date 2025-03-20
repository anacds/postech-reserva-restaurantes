package com.fiap.postech_reserva_restaurantes.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

public class ObterMesaPorIdUseCase {
	
	@Autowired
	public MesaGateway mesaGateway;
	
	public final MesaEntity obter(Long id) {
		return mesaGateway.obterPorId(id);
	}
}
