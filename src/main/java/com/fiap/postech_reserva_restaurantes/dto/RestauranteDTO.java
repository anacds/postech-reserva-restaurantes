package com.fiap.postech_reserva_restaurantes.dto;

import java.util.List;

public record RestauranteDTO(String id,
                             String cnpj,
                             String nome,
                             Double nota,
                             List<String> comentarios,
                             EnderecoDTO endereco,
                             List<String> tipoCozinha,
                             List<HorarioFuncionamentoDTO> horariosFuncionamento,
                             int capacidade) {
}
