package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ListarUsuariosUseCase {

    private final IUsuarioGateway usuarioGateway;

    public ListarUsuariosUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "Gateway de usuário não pode ser nulo.");
    }

    public List<UsuarioEntity> executar() {
        return usuarioGateway.listarTodos();
    }
}
