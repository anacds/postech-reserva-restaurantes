package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class BuscarMesaPorIdUseCase {
	
	@Autowired
	public MesaGateway mesaGateway;
	
	public MesaEntity buscar(Long id) {
		try {
			return mesaGateway.obterPorId(id);
			
		} catch (Exception e) {
			System.out.println("Mesa não encontrada");
			return null;
		}
	}
}
