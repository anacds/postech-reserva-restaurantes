package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

public class HorarioReservaMesaEntity {

	public final LocalDateTime horarioInicio, horarioFim;

	public HorarioReservaMesaEntity(LocalDateTime horarioInicio, LocalDateTime horarioFim) {
		super();
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}
	
	
}
