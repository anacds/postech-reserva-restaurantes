package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RemoverUsuarioUseCase {

    private final IUsuarioGateway usuarioGateway;

    public RemoverUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "Gateway de usuário não pode ser nulo.");
    }

    public boolean executar(String id) {
        return usuarioGateway.remover(id);
    }
}
