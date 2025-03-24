package com.fiap.postech_reserva_restaurantes.dto;

import java.util.List;

import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public record MesaDTO(
		String id, 
		Integer numero,
		Integer capacidade, 
		String idRestaurante, 
		List<ReservaEntity> reservas) {

	public MesaDTO(String id, Integer numero, Integer capacidade, String idRestaurante, List<ReservaEntity> reservas) {
		this.id = id;
		this.numero = numero;
		this.capacidade = capacidade;
		this.idRestaurante = idRestaurante;
		this.reservas = reservas;
	}

}
