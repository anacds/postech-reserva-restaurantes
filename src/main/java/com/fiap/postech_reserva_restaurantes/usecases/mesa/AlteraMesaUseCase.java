package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class AlteraMesaUseCase {
	
	@Autowired
	public static MesaGateway mesaGateway;
	
	
	public static MesaEntity alterarMesa(MesaDTO mesaDTO) {
		
		try {
			RestauranteEntity restaurante = new RestauranteEntity();
			
			MesaEntity mesa = new MesaEntity(mesaDTO.numero(), mesaDTO.capacidade(), restaurante, mesaDTO.reservas());
			return mesaGateway.alterarMesa(mesa);
			
		} catch (Exception e) {
			System.out.println("Mesa não foi alterada");
			return null;
		}
	}

}