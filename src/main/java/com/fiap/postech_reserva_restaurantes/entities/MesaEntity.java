package com.fiap.postech_reserva_restaurantes.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MesaEntity {
	
	@Id
	private Long id;
	public final Integer numero, capacidade;
	public final RestauranteEntity restaurante;
	public final List<HorarioReservaMesaEntity> indisponivel;
	
	public MesaEntity(Integer numero, Integer capacidade, RestauranteEntity restaurante, List<HorarioReservaMesaEntity> indisponivel) 
			throws IllegalArgumentException{
		
		validaNumero(capacidade);
		validaNumero(numero);
		
		this.numero = numero;
		this.capacidade = capacidade;
		this.restaurante = restaurante;
		
		if (Objects.isNull(indisponivel)) {
			this.indisponivel = new ArrayList<HorarioReservaMesaEntity>();
		}else {
			this.indisponivel = indisponivel;
		}
		
	}

	public Long getId() {
		return id;
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
	
	public List<HorarioReservaMesaEntity> getIndisponivel() {
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
