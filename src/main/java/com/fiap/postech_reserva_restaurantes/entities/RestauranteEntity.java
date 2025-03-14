package com.fiap.postech_reserva_restaurantes.entities;

import java.util.List;
import java.util.Objects;


public class RestauranteEntity {
    private String id;
    private String nome;
    private NotaEntity nota;
    private List<ComentarioEntity> comentarios;
    private CNPJEntity cnpj;
    private EnderecoEntity endereco;
    private List<String> tipoCozinha;
    private List<HorarioFuncionamentoEntity> horariosFuncionamento;
    private List<MesaEntity> mesas;
    private int capacidade;

    public RestauranteEntity(String id,
                             String nome,
                             NotaEntity nota,
                             List<ComentarioEntity> comentarios,
                             CNPJEntity cnpj,
                             EnderecoEntity endereco,
                             List<String> tipoCozinha,
                             List<HorarioFuncionamentoEntity> horariosFuncionamento,
                             List<MesaEntity> mesas,
                             int capacidade) {

        validar(nome, cnpj, endereco, tipoCozinha, capacidade);

        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horariosFuncionamento = horariosFuncionamento;
        this.mesas = mesas;
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public NotaEntity getNota() {
        return nota;
    }

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
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

    public List<MesaEntity> getMesas() {
        return mesas;
    }

    public int getCapacidade() {
        return capacidade;
    }

    private void validar(String nome, CNPJEntity cnpj, EnderecoEntity endereco, List<String> tipoCozinha, List<MesaEntity> mesas, int capacidade) {
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
        if (Objects.isNull(mesas) || mesas.isEmpty()) {
            throw new IllegalArgumentException("O restaurante deve ter ao menos uma mesa");
        }
        if (Objects.isNull(capacidade) || capacidade <= 0) {
            throw new IllegalArgumentException("É obrigatório informar uma capacidade maior que zero.");
        }
    }
}
