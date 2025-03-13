package com.fiap.postech_reserva_restaurantes.entities;

import org.hibernate.validator.constraints.br.CNPJ;

public class CNPJEntity {
    @CNPJ(message = "O CNPJ informado é inválido.")
    private final String valor;

    public CNPJEntity(String valor) {
        validar(valor);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    private void validar(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório");
        }
    }
}
