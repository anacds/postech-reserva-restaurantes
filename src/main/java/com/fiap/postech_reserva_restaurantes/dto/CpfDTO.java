package com.fiap.postech_reserva_restaurantes.dto;

import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

public class CpfDTO {

    private String cpf;

    public CpfDTO() {}

    public CpfDTO(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Conversão para Value Object
    public Cpf toValueObject() {
        return new Cpf(this.cpf);
    }

    // Conversão estática de Value Object para DTO
    public static CpfDTO fromValueObject(Cpf cpf) {
        return new CpfDTO(cpf.getValue());
    }
}
