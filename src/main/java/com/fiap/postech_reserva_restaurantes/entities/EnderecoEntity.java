package com.fiap.postech_reserva_restaurantes.entities;

import java.util.Objects;

public class EnderecoEntity {

    private final String rua;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String estado;
    private final String cep;
    private final String complemento;

    public EnderecoEntity(String rua, String numero, String bairro, String cidade, String estado, String cep, String complemento) {
        this.rua = Objects.requireNonNull(rua, "Rua não pode ser nula.");
        this.numero = Objects.requireNonNull(numero, "Número não pode ser nulo.");
        this.bairro = Objects.requireNonNull(bairro, "Bairro não pode ser nulo.");
        this.cidade = Objects.requireNonNull(cidade, "Cidade não pode ser nula.");
        this.estado = Objects.requireNonNull(estado, "Estado não pode ser nulo.");
        this.cep = validarCEP(cep);
        this.complemento = complemento;
    }

    private String validarCEP(String cep) {
        if (cep == null || !cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido. O formato correto é 99999-999.");
        }
        return cep;
    }

    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }
    public String getComplemento() { return complemento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnderecoEntity)) return false;
        EnderecoEntity that = (EnderecoEntity) o;
        return rua.equals(that.rua)
                && numero.equals(that.numero)
                && bairro.equals(that.bairro)
                && cidade.equals(that.cidade)
                && estado.equals(that.estado)
                && cep.equals(that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, numero, bairro, cidade, estado, cep);
    }
}
