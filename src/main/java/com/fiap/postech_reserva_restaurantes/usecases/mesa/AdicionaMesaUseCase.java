package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class AdicionaMesaUseCase {
	
	@Autowired
	public static MesaGateway mesaGateway;
	
	public static MesaEntity adicionarMesa(MesaDTO mesaDTO) {
		
//		RestauranteEntity restaurante = BuscarRestaurantePorId(mesaDTO.idRestaurante());
		RestauranteEntity restaurante = new RestauranteEntity();
		
		MesaEntity mesa = new MesaEntity(mesaDTO.numero(), mesaDTO.capacidade(), restaurante, null);
		
		try {
			return mesaGateway.criarMesa(mesa);
		} catch (Exception e) {
			System.out.println("Não foi possível criar uma mesa");
			return null;
		}
		
	}
}
