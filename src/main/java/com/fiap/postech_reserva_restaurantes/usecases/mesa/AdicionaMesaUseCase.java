package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.BuscaRestaurantePorIdUseCase;

@Service
public class AdicionaMesaUseCase {
	
	@Autowired
	public static MesaGateway mesaGateway;
	
	@Autowired
	public static BuscaRestaurantePorIdUseCase buscaRestaurantePorIdUseCase;
	
	public static MesaEntity adicionarMesa(MesaDTO mesaDTO) {
		
		Optional<RestauranteEntity> restauranteOpt = buscaRestaurantePorIdUseCase.buscarRestaurantePorId(mesaDTO.idRestaurante());
		
		MesaEntity mesa = new MesaEntity(mesaDTO.numero(), mesaDTO.capacidade(), restauranteOpt.get(), new ArrayList<ReservaEntity>());
	
		try {
			return mesaGateway.criarMesa(mesa);
		} catch (Exception e) {
			System.out.println("Não foi possível criar uma mesa");
			return null;
		}
		
	}
}
