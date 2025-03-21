package com.fiap.postech_reserva_restaurantes.entities;

import java.util.List;
import java.util.Objects;

public class MesaEntity {
	
	public final Integer numero, capacidade;
	public final RestauranteEntity restaurante;
	public final List<MesaIndisponibilidadeEntity> indisponivel;
	
	public MesaEntity(Integer numero, Integer capacidade, RestauranteEntity restaurante, List<MesaIndisponibilidadeEntity> indisponivel) 
			throws IllegalArgumentException{
		
		validaNumero(capacidade);
		validaNumero(numero);
		
		this.numero = numero;
		this.capacidade = capacidade;
		this.restaurante = restaurante;
		this.indisponivel = indisponivel;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public RestauranteEntity getRestaurante() {
		return restaurante;
	}
	
	public List<MesaIndisponibilidadeEntity> getIndisponivel() {
		return indisponivel;
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
