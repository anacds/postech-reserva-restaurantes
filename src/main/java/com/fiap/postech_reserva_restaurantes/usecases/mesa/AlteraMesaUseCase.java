package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.BuscaRestaurantePorIdUseCase;

@Service
public class AlteraMesaUseCase {
	
	@Autowired
	public  MesaGateway mesaGateway;
	
	@Autowired
	public BuscaRestaurantePorIdUseCase buscaRestaurantePorIdUseCase;
	
	public MesaEntity alterarMesa(MesaDTO mesaDTO) {
		
		try {
			Optional<RestauranteEntity> restaurante =  buscaRestaurantePorIdUseCase.buscarRestaurantePorId(mesaDTO.idRestaurante());
	
			MesaEntity mesa = new MesaEntity(mesaDTO.numero(), mesaDTO.capacidade(), restaurante.get(), mesaDTO.reservas());
			
			mesa.setId(mesaDTO.id());
			mesa.setIdRestaurante(mesaDTO.idRestaurante());
			
			return mesaGateway.alterarMesa(mesa);
			
		} catch (Exception e) {
			System.out.println("Mesa não foi alterada");
			return null;
		}
	}

}