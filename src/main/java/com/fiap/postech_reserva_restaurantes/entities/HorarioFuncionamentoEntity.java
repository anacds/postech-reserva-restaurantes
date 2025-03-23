package com.fiap.postech_reserva_restaurantes.entities;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class HorarioFuncionamentoEntity {
	private DiaDaSemana diaSemana;
	private LocalDateTime horarioAbertura;
	private LocalDateTime horarioFechamento;
	
    public HorarioFuncionamentoEntity(DiaDaSemana diaSemana, LocalDateTime horarioAbertura,
			LocalDateTime horarioFechamento) {
    	validar(diaSemana, horarioAbertura, horarioFechamento);
    	this.diaSemana = diaSemana;
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
	}
    
    public DiaDaSemana getDiaSemana() {
		return diaSemana;
	}

	public LocalDateTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public LocalDateTime getHorarioFechamento() {
		return horarioFechamento;
	}

	private void validar(DiaDaSemana diaSemana, LocalDateTime horarioAbertura, LocalDateTime horarioFechamento) {
        if (Objects.isNull(diaSemana)) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um dia da semana para funcionamento.");
        }
        if (Objects.isNull(horarioAbertura)) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um horário de abertura.");
        }
        if (Objects.isNull(horarioFechamento)) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um horário de fechamento.");
        }

        try {
//            LocalTime abertura = LocalTime.parse(horarioAbertura);
//            LocalTime fechamento = LocalTime.parse(horarioFechamento);
//
//            // Ajusta fechamento para o dia seguinte se for 00:00
//            if (fechamento.equals(LocalTime.MIDNIGHT)) {
//                fechamento = LocalTime.MAX;
//            }
//
//            if (!fechamento.isAfter(abertura)) {
//                throw new IllegalArgumentException("O horário de fechamento deve ser posterior ao horário de abertura.");
//            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Os horários devem estar no formato HH:mm.");
        }
    }
}
