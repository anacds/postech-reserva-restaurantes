package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class AtualizarUsuarioUseCase {

    private final IUsuarioGateway usuarioGateway;

    public AtualizarUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "Gateway de usuário não pode ser nulo.");
    }

    public Optional<UsuarioEntity> executar(String id, String nome, Cpf cpf, LocalDate dataNascimento, String telefone, EnderecoEntity endereco) {
        Optional<UsuarioEntity> existente = usuarioGateway.buscarPorId(id);

        if (existente.isEmpty()) {
            return Optional.empty();
        }

        UsuarioEntity atualizado = new UsuarioEntity(
            id,
            nome,
            cpf,
            dataNascimento,
            telefone,
            endereco
        );

        return Optional.of(usuarioGateway.atualizar(atualizado));
    }
}
