package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import java.time.LocalDate;

public record UsuarioDTO(
    String nome,
    String cpf,
    LocalDate dataNascimento,
    String telefone,
    EnderecoEntity endereco
) {}
