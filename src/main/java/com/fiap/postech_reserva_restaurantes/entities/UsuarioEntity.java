package com.fiap.postech_reserva_restaurantes.entities;

import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import java.time.LocalDate;
import java.util.Objects;

public class UsuarioEntity extends PessoaEntity {
    private final String id;
    private final String telefone;
    private final EnderecoEntity endereco;

    public UsuarioEntity(String id, String nome, Cpf cpf, LocalDate dataNascimento, String telefone, EnderecoEntity endereco) {
        super(nome, cpf, dataNascimento);
        this.id = Objects.requireNonNull(id, "ID não pode ser nulo.");
        this.telefone = validarTelefone(telefone);
        this.endereco = Objects.requireNonNull(endereco, "Endereço não pode ser nulo.");
    }

    private String validarTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido. Use o formato (99) 99999-9999.");
        }
        return telefone;
    }

    public String getId() { return id; }
    public String getTelefone() { return telefone; }
    public EnderecoEntity getEndereco() { return endereco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity)) return false;
        if (!super.equals(o)) return false;
        UsuarioEntity usuario = (UsuarioEntity) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf=" + getCpf() +
                ", dataNascimento=" + getDataNascimento() +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
