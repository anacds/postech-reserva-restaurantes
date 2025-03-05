package com.fiap.postech_reserva_restaurantes.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "horariosFuncionamento")
public class HorarioFuncionamentoEntity {
    private String diaSemana;
    private String horarioAbertura;
    private String horarioFechamento;
}
