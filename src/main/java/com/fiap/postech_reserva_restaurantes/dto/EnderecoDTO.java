package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;

public record EnderecoDTO (String rua,
                           String numero,
                           String bairro,
                           String cidade,
                           String estado,
                           String cep,
                           String complemento) {
}