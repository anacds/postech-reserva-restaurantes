package com.fiap.postech_reserva_restaurantes.entities;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "restaurantes")
@Setter
public class RestauranteEntity {

    @Id
    private String id;
    private CNPJEntity cnpj;
    private String nome;
    private NotaEntity nota;
    private List<ComentarioEntity> comentarios;
    private EnderecoEntity endereco;
    private List<String> tipoCozinha;
    private List<HorarioFuncionamentoEntity> horariosFuncionamento;
    private int capacidade;

    public RestauranteEntity(String nome, CNPJEntity cnpj, EnderecoEntity endereco,
                             NotaEntity nota, List<ComentarioEntity> comentarios,
                             List<String> tipoCozinha, List<HorarioFuncionamentoEntity> horariosFuncionamento, int capacidade) {
        super();
        this.nome = nome;
        this.cnpj = cnpj;
        this.nota = nota;
        this.comentarios = comentarios;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horariosFuncionamento = horariosFuncionamento;
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public CNPJEntity getCnpj() {
        return cnpj;
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
}