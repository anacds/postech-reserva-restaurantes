package com.fiap.postech_reserva_restaurantes.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.MesaRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IMesaGateway;

@Service
public class MesaGateway implements IMesaGateway{
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public MesaEntity obterPorId(Long id) {
		return mesaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Mesa não existe"));
	}

}
