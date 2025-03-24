package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;

public record EnderecoDTO(String rua,
                          String numero,
                          String bairro,
                          String cidade,
                          String estado,
                          String cep,
                          String complemento) {

    public EnderecoEntity toEntity() {
        return new EnderecoEntity(rua, numero, bairro, cidade, estado, cep, complemento);
    }

    public static EnderecoDTO fromEntity(EnderecoEntity endereco) {
        return new EnderecoDTO(
            endereco.getRua(),
            endereco.getNumero(),
            endereco.getBairro(),
            endereco.getCidade(),
            endereco.getEstado(),
            endereco.getCep(),
            endereco.getComplemento()
        );
    }
}
