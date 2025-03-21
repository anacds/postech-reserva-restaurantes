package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import org.springframework.stereotype.Service;

@Service
public class RemoverUsuarioUseCase {
    private final IUsuarioGateway usuarioGateway;

    public RemoverUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public boolean executar(String id) {
        if (usuarioGateway.buscarPorId(id).isEmpty()) {
            return false;
        }

        usuarioGateway.remover(id);
        return true;
    }
}
