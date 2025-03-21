package com.fiap.postech_reserva_restaurantes.entities;

import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import java.time.LocalDate;
import java.util.Objects;

public abstract class PessoaEntity {
    protected final String nome;
    protected final Cpf cpf;
    protected final LocalDate dataNascimento;

    public PessoaEntity(String nome, Cpf cpf, LocalDate dataNascimento) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo.");
        this.cpf = Objects.requireNonNull(cpf, "CPF não pode ser nulo.");
        this.dataNascimento = Objects.requireNonNull(dataNascimento, "Data de nascimento não pode ser nula.");
    }

    public String getNome() { return nome; }
    public Cpf getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaEntity)) return false;
        PessoaEntity pessoa = (PessoaEntity) o;
        return cpf.equals(pessoa.cpf); // Comparação baseada no CPF, pois é único
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
