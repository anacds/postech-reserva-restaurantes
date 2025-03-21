package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AtualizarUsuarioUseCase {
    private final IUsuarioGateway usuarioGateway;

    public AtualizarUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Optional<UsuarioEntity> executar(String id, String nome, String cpf, LocalDate dataNascimento, String telefone, EnderecoEntity endereco) {
        Optional<UsuarioEntity> usuarioExistente = usuarioGateway.buscarPorId(id);

        if (usuarioExistente.isEmpty()) {
            return Optional.empty();
        }

        UsuarioEntity usuarioAtualizado = new UsuarioEntity(id, nome, new Cpf(cpf), dataNascimento, telefone, endereco);
        usuarioGateway.salvar(usuarioAtualizado); // Reaproveita o método salvar para atualizar

        return Optional.of(usuarioAtualizado);
    }
}
