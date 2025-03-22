package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class HorarioFuncionamentoEntity {
    private String diaSemana;
    private String horarioAbertura;
    private String horarioFechamento;

    public HorarioFuncionamentoEntity(String diaSemana, String horarioAbertura, String horarioFechamento) {
        validar(diaSemana, horarioAbertura, horarioFechamento);
        this.diaSemana = diaSemana;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    private void validar(String diaSemana, String horarioAbertura, String horarioFechamento) {
        if (Objects.isNull(diaSemana) || diaSemana.isBlank()) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um dia da semana para funcionamento.");
        }
        if (Objects.isNull(horarioAbertura) || horarioAbertura.isBlank()) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um horário de abertura.");
        }
        if (Objects.isNull(horarioFechamento) || horarioFechamento.isBlank()) {
            throw new IllegalArgumentException("Deve ser informado pelo menos um horário de fechamento.");
        }

        try {
            LocalTime abertura = LocalTime.parse(horarioAbertura);
            LocalTime fechamento = LocalTime.parse(horarioFechamento);

            // Ajusta fechamento para o dia seguinte se for 00:00
            if (fechamento.equals(LocalTime.MIDNIGHT)) {
                fechamento = LocalTime.MAX;
            }

            if (!fechamento.isAfter(abertura)) {
                throw new IllegalArgumentException("O horário de fechamento deve ser posterior ao horário de abertura.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Os horários devem estar no formato HH:mm.");
        }
    }
}
