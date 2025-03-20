package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

public class MesaIndisponibilidadeEntity {

	public final LocalDateTime horarioInicio, horarioFim;

	public MesaIndisponibilidadeEntity(LocalDateTime horarioInicio, LocalDateTime horarioFim) {
		super();
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}
	
	
}
