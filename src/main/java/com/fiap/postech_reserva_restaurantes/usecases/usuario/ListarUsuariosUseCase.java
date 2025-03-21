package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarUsuariosUseCase {
    private final IUsuarioGateway usuarioGateway;

    public ListarUsuariosUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<UsuarioEntity> executar() {
        return usuarioGateway.listarTodos();
    }
}
