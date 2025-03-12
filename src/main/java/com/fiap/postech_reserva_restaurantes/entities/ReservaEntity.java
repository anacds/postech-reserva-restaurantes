package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

public class ReservaEntity {

	public final MesaEntity mesa;
	public final RestauranteEntity restaurante;
	public final LocalDateTime dataHoraInicio;
	public final LocalDateTime dataHoraFim;
	public final DiaDaSemana diaDaSemana;
	//TODO: colocar atributos
	
	
	
	public ReservaEntity(MesaEntity mesa, RestauranteEntity restaurante, LocalDateTime dataHoraInicio,
			LocalDateTime dataHoraFim) {
		super();
		this.mesa = mesa;
		this.restaurante = restaurante;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.diaDaSemana = getDiaDaSemana();
		
	}
	
	private DiaDaSemana getDiaDaSemana() {
		DiaDaSemana dia = null;
		String dayOfWeek = dataHoraInicio.getDayOfWeek().toString();
		
		switch (dayOfWeek) {
			case "Monday": {
				dia = diaDaSemana.SEGUNDA;
			}
			case "Tuesday": {
				dia = diaDaSemana.TERCA;
			}
			case "Wednesday":{
				dia = diaDaSemana.QUARTA;
			}
			case "Thursday":{
				dia = diaDaSemana.QUINTA;
			}
			case "Friday":{
				dia = diaDaSemana.SEXTA;
			}
			case "Saturday":{
				dia = diaDaSemana.SABADO;
			}
			case "Sunday":{
				dia = diaDaSemana.DOMINGO;
			}
		}
		return dia;
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

	//TODO: Validar dados

}
