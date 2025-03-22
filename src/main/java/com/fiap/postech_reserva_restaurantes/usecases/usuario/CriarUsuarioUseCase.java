package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CriarUsuarioUseCase {

    private final IUsuarioGateway usuarioGateway;

    public CriarUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "Gateway de usuário não pode ser nulo.");
    }

    public UsuarioEntity executar(UsuarioEntity usuario) {
        if (usuarioGateway.buscarPorCpf(usuario.getCpf()).isPresent()) {
            throw new IllegalStateException("Já existe um usuário com este CPF.");
        }

        UsuarioEntity novoUsuario = new UsuarioEntity(
            UUID.randomUUID().toString(),
            usuario.getNome(),
            usuario.getCpf(),
            usuario.getDataNascimento(),
            usuario.getTelefone(),
            usuario.getEndereco()
        );

        return usuarioGateway.salvar(novoUsuario);
    }
}
