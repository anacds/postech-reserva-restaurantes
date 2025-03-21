package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ReservaEntity {

	@Id
	private Long id;
	public final MesaEntity mesa;
	public final UsuarioEntity usuario;
	public final RestauranteEntity restaurante;
	
	public final LocalDateTime dataHoraInicio;
	public final LocalDateTime dataHoraFim;
	
	public final DiaDaSemana diaDaSemana;
	public final String status, observacao;
	public final int qtdPessoas;
	
	public ReservaEntity(MesaEntity mesa, UsuarioEntity usuario, RestauranteEntity restaurante,
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim,String status,
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
		this.diaDaSemana = getDiaDaSemana();
	}

	private DiaDaSemana getDiaDaSemana() {
		DiaDaSemana dia = null;
		String dayOfWeek = dataHoraInicio.getDayOfWeek().toString();
		
		switch (dayOfWeek) {
			case "MONDAY": {
				dia = diaDaSemana.SEGUNDA;
			}
			case "TUESDAY": {
				dia = diaDaSemana.TERCA;
			}
			case "WEDNESDAY":{
				dia = diaDaSemana.QUARTA;
			}
			case "THURSDAY":{
				dia = diaDaSemana.QUINTA;
			}
			case "FRIDAY":{
				dia = diaDaSemana.SEXTA;
			}
			case "SATURDAY":{
				dia = diaDaSemana.SABADO;
			}
			case "SUNDAY":{
				dia = diaDaSemana.DOMINGO;
			}
		}
		return dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MesaEntity getMesa() {
		return mesa;
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

}
