package com.fiap.postech_reserva_restaurantes.entities;

import lombok.Data;

@Data
public class HorarioFuncionamentoEntity {
    private String diaSemana;
    private String horarioAbertura;
    private String horarioFechamento;
}
