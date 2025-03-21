package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarUsuarioUseCase {
    private final IUsuarioGateway usuarioGateway;

    public BuscarUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Optional<UsuarioEntity> buscarPorId(String id) {
        return usuarioGateway.buscarPorId(id);
    }

    public Optional<UsuarioEntity> buscarPorCpf(String cpf) {
        return usuarioGateway.buscarPorCpf(new Cpf(cpf));
    }
}
