package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Service
public class CriarUsuarioUseCase {
    private final IUsuarioGateway usuarioGateway;

    public CriarUsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "Gateway de usuário não pode ser nulo.");
    }

    public UsuarioEntity executar(String nome, String cpf, LocalDate dataNascimento, String telefone, EnderecoEntity endereco) {
        Cpf cpfObj = new Cpf(cpf);

        if (usuarioGateway.buscarPorCpf(cpfObj).isPresent()) {
            throw new IllegalStateException("Já existe um usuário com este CPF.");
        }

        // Gerando ID único para manter o padrão do grupo
        String id = UUID.randomUUID().toString();

        UsuarioEntity usuario = new UsuarioEntity(id, nome, cpfObj, dataNascimento, telefone, endereco);
        return usuarioGateway.salvar(usuario);
    }
}
