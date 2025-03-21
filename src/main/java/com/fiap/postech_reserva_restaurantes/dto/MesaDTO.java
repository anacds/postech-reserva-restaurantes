package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;

public record MesaDTO(
		Long id, 
		Integer numero,
		Integer capacidade, 
		Long idRestaurante) {

}
