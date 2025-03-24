package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;

@Document("reservas")
public class ReservaEntity {

	@Id
	private String id;
	
	@DBRef
	public MesaEntity mesa;
	@DBRef
	public final UsuarioEntity usuario;
	@DBRef
	public final RestauranteEntity restaurante;
	
	@Field(name = "mesa_id")
	private String idMesa;
	@Field(name = "restaurante_id")
	private String idRestaurante;
	@Field(name = "usuario_id")
	private String idUsuario;
	
	@NotNull
	public final LocalDateTime dataHoraInicio;
	@NotNull
	public final LocalDateTime dataHoraFim;
	
	public String status, observacao;
	public final int qtdPessoas;
	
	public ReservaEntity(MesaEntity mesa, UsuarioEntity usuario, RestauranteEntity restaurante,
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String status,
			String observacao, int qtdPessoas) {
		super();
		this.mesa = mesa;
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.status = status;
		this.observacao = observacao;
		this.qtdPessoas = qtdPessoas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MesaEntity getMesa() {
		return mesa;
	}
	
	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}

	public RestauranteEntity getRestaurante() {
		return restaurante;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public String getStatus() {
		return status;
	}

	public String getObservacao() {
		return observacao;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(String idMesa) {
		this.idMesa = idMesa;
	}
}
