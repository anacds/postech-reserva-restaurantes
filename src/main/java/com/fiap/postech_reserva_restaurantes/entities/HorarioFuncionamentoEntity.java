package com.fiap.postech_reserva_restaurantes.entities;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HorarioFuncionamentoEntity {
    private DiaDaSemana diaSemana;
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;
}
