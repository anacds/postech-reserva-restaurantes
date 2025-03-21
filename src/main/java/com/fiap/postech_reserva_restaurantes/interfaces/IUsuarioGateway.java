package com.fiap.postech_reserva_restaurantes.interfaces;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import java.util.List;
import java.util.Optional;

public interface IUsuarioGateway {
    UsuarioEntity salvar(UsuarioEntity usuario);
    Optional<UsuarioEntity> buscarPorId(String id);
    Optional<UsuarioEntity> buscarPorCpf(Cpf cpf);
    List<UsuarioEntity> listarTodos();
    void remover(String id);
}
