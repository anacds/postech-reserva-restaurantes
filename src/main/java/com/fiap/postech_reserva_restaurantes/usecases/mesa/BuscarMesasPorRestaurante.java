package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;
@Service
public class BuscarMesasPorRestaurante {
	
	@Autowired
	public MesaGateway mesaGateway;
	
	public List<MesaEntity> buscar(String idRestaurante){
		try {
			return mesaGateway.buscarMesasPorRestaurante(idRestaurante);
			
		} catch (Exception e) {
			System.out.println("Não foi possível achar mesas para esse restaurante");
			return null;
		}
	} 
}
