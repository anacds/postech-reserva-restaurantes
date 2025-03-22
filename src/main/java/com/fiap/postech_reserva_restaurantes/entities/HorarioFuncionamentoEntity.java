package com.fiap.postech_reserva_restaurantes.entities;


import java.time.LocalDateTime;
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
    }
}