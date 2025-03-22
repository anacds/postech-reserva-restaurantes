package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

import java.time.LocalDate;

public record UsuarioDTO(
    String nome,
    CpfDTO cpf,
    LocalDate dataNascimento,
    String telefone,
    EnderecoDTO endereco
) {

    public UsuarioEntity toEntity(String id) {
        return new UsuarioEntity(
            id,
            nome,
            cpf.toValueObject(),
            dataNascimento,
            telefone,
            endereco.toEntity()
        );
    }

    public static UsuarioDTO fromEntity(UsuarioEntity entity) {
        return new UsuarioDTO(
            entity.getNome(),
            CpfDTO.fromValueObject(entity.getCpf()),
            entity.getDataNascimento(),
            entity.getTelefone(),
            EnderecoDTO.fromEntity(entity.getEndereco())
        );
    }
}
