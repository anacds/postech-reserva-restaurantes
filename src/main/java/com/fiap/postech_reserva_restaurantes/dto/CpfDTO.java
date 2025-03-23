package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

public record CpfDTO(String cpf) {

    public Cpf toValueObject() {
        return new Cpf(this.cpf);
    }

    public static CpfDTO fromValueObject(Cpf cpf) {
        return new CpfDTO(cpf.getValue());
    }
}
