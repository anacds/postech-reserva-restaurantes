package com.fiap.postech_reserva_restaurantes.entities;

import java.util.List;
import java.util.Objects;

public class MesaEntity {
	
	public final Integer numero, capacidade;
	public final boolean disponibilidade;
	public final RestauranteEntity restaurante;
	public final List<ReservaEntity> reservas;
	
	public MesaEntity(Integer numero, Integer capacidade, boolean disponibilidade,
			RestauranteEntity restaurante, List<ReservaEntity> reservas) throws IllegalArgumentException{
		
		validaNumero(capacidade);
		validaNumero(numero);
		
		this.numero = numero;
		this.capacidade = capacidade;
		this.disponibilidade = disponibilidade;
		this.restaurante = restaurante;
		this.reservas = reservas;
	}


	public Integer getNumero() {
		return numero;
	}


	public Integer getCapacidade() {
		return capacidade;
	}


	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	
	public RestauranteEntity getRestaurante() {
		return restaurante;
	}


	public List<ReservaEntity> getReservas() {
		return reservas;
	}

	public void addReserva(ReservaEntity reserva) {
		reservas.add(reserva);
	}
	
	
	private void validaNumero(Integer valor) throws IllegalArgumentException {
		if (Objects.isNull(valor)) {
			throw new IllegalArgumentException("Dados inválidos");
		}
		if(valor < 0){
			throw new IllegalArgumentException("Dados inválidos");
		}
	}
	
	
	
}
