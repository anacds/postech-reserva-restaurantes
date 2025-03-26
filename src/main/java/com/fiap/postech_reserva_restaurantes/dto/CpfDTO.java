package com.fiap.postech_reserva_restaurantes.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

public record CpfDTO(String cpf) {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CpfDTO(@JsonProperty("cpf") String cpf) {
        this.cpf = cpf;
    }

    public Cpf toValueObject() {
        return new Cpf(this.cpf);
    }

    public static CpfDTO fromValueObject(Cpf cpf) {
        return new CpfDTO(cpf.getValue());
    }
}
