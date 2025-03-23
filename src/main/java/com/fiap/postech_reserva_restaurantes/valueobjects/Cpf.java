package com.fiap.postech_reserva_restaurantes.valueobjects;

import java.util.Objects;

public class Cpf {
    private final String value;

    public Cpf(String value) {
        this.value = validarCpf(value);
    }

    private String validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido: deve conter 11 dígitos numéricos.");
        }
        return cpf;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.substring(0, 3) + "." + value.substring(3, 6) + "." + value.substring(6, 9) + "-" + value.substring(9);
    }
}