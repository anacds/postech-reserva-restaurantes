package com.fiap.postech_reserva_restaurantes.entities;

import java.util.List;
import java.util.Objects;


public class RestauranteEntity {
    private String id;
    private String nome;
    private CNPJEntity cnpj;
    private EnderecoEntity endereco;
    private List<String> tipoCozinha;
    private List<HorarioFuncionamentoEntity> horariosFuncionamento;
    private int capacidade;

    public RestauranteEntity(String id,
                             String nome,
                             CNPJEntity cnpj,
                             EnderecoEntity endereco,
                             List<String> tipoCozinha,
                             List<HorarioFuncionamentoEntity> horariosFuncionamento,
                             int capacidade) {

        validar(nome, cnpj, endereco, tipoCozinha, capacidade);

        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horariosFuncionamento = horariosFuncionamento;
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CNPJEntity getCnpj() {
        return cnpj;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public List<String> getTipoCozinha() {
        return tipoCozinha;
    }

    public List<HorarioFuncionamentoEntity> getHorariosFuncionamento() {
        return horariosFuncionamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    private void validar(String nome, CNPJEntity cnpj, EnderecoEntity endereco, List<String> tipoCozinha, int capacidade) {
        if (Objects.isNull(nome)) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }
        if (Objects.isNull(cnpj)) {
            throw new IllegalArgumentException("O CNPJ é obrigatório");
        }
        if (Objects.isNull(endereco)) {
            throw new IllegalArgumentException("O endereço é obrigatório");
        }
        if (Objects.isNull(tipoCozinha) || tipoCozinha.isEmpty()) {
            throw new IllegalArgumentException("O tipo de cozinha é obrigatório");
        }
        if (Objects.isNull(capacidade) || capacidade <= 0) {
            throw new IllegalArgumentException("É obrigatório informar uma capacidade maior que zero.");
        }
    }
}
