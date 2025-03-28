package com.fiap.postech_reserva_restaurantes.gateways;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.UsuarioRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioGateway implements IUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioGateway(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity atualizar(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario); // `save` do JPA já trata create/update
    }

    @Override
    public Optional<UsuarioEntity> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<UsuarioEntity> buscarPorCpf(Cpf cpf) {
        return usuarioRepository.findByCpf(cpf.getValue());
    }

    @Override
    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean remover(String id) {
        if (!usuarioRepository.existsById(id)) return false;
        usuarioRepository.deleteById(id);
        return true;
    }
}
