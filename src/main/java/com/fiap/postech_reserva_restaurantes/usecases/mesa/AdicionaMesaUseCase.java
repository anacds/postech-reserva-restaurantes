package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
	public MesaGateway mesaGateway;
	
	@Autowired
	public BuscaRestaurantePorIdUseCase buscaRestaurantePorIdUseCase;
	
	public MesaEntity adicionarMesa(MesaDTO mesaDTO) {
		
		try {
			
			Optional<RestauranteEntity> restauranteOpt = buscaRestaurantePorIdUseCase.buscarRestaurantePorId(mesaDTO.idRestaurante());
			
			if (Objects.isNull(restauranteOpt)) {
				throw new Exception("Restaurante de id" + mesaDTO.idRestaurante() + " não existe");
			}
	
			MesaEntity mesa = new MesaEntity(mesaDTO.numero(), mesaDTO.capacidade(), restauranteOpt.get(), new ArrayList<ReservaEntity>());
			mesa.setIdRestaurante(mesaDTO.idRestaurante());
			
			// se o id for especificado, ele será criado, caso contrário um id será gerado automaticamente
			if (!Objects.isNull(mesaDTO.id()) && !"".equals(mesaDTO.id())) {
				mesa.setId(mesaDTO.id());
			}
			
			return mesaGateway.criarMesa(mesa);
			
		} catch (Exception e) {
			System.out.println("Não foi possível criar uma mesa");
			e.printStackTrace();
			return null;
		}
		
	}
}
