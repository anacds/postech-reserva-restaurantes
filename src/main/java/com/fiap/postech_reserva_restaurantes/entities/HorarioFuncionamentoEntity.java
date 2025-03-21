package com.fiap.postech_reserva_restaurantes.entities;

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
    }
}
