package com.fiap.postech_reserva_restaurantes.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "mesas")
public class MesaEntity {
	
	@Id
	private String id;
	public final Integer numero, capacidade;

	@Field(name = "restaurante_id")
	private String idRestaurante;
	
	public final RestauranteEntity restaurante;
	public final List<ReservaEntity> reservas;
	
	public MesaEntity(Integer numero, Integer capacidade, RestauranteEntity restaurante, List<ReservaEntity> reservas) 
			throws IllegalArgumentException{
		
		validaNumero(capacidade);
		validaNumero(numero);
		
		this.numero = numero;
		this.capacidade = capacidade;
		this.restaurante = restaurante;
		
		if (Objects.isNull(reservas)) {
			this.reservas = new ArrayList<ReservaEntity>();
		}else {
			this.reservas = reservas;
		}
		
	}

	public String getId() {
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
	
	public List<ReservaEntity> getReservas() {
		return reservas;
	}
	
	public String getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	private void validaNumero(Integer valor) throws IllegalArgumentException {
		if (Objects.isNull(valor)) {
			throw new IllegalArgumentException("Dados inválidos");
		}
		if(valor < 0){
			throw new IllegalArgumentException("Dados inválidos");
		}
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
