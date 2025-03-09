package com.fiap.postech_reserva_restaurantes.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "restaurantes")
public class RestauranteEntity {
    private String id;
    private String nome;
    private String cnpj;
    private EnderecoEntity endereco;
    private List<String> tipoCozinha;
    private List<HorarioFuncionamentoEntity> horariosFuncionamento;
    private int capacidade;

}
