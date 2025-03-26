package com.fiap.postech_reserva_restaurantes.entities;

import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class UsuarioEntity extends PessoaEntity {

    private final String id;
    private final String telefone;
    private final EnderecoEntity endereco;

    public UsuarioEntity(
        String id,
        String nome,
        Cpf cpf,
        LocalDate dataNascimento,
        String telefone,
        EnderecoEntity endereco
    ) {
        super(nome, cpf, dataNascimento);
        this.id = Objects.requireNonNull(id, "ID não pode ser nulo.");
        this.telefone = Objects.requireNonNull(telefone, "Telefone não pode ser nulo.");
        this.endereco = Objects.requireNonNull(endereco, "Endereço não pode ser nulo.");
    }

    public String getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity)) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id.equals(that.id); // Igualdade baseada em ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
