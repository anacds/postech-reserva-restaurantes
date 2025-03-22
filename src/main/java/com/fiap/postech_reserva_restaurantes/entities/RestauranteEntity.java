package com.fiap.postech_reserva_restaurantes.entities;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

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
        validar(cnpj, nome, tipoCozinha, horariosFuncionamento, capacidade);
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

    private void validar(CNPJEntity cnpj,
                         String nome,
                         List<String> tipoCozinha,
                         List<HorarioFuncionamentoEntity> horariosFuncionamento,
                         int capacidade){
        if (Objects.isNull(cnpj) || Objects.isNull(cnpj.getValor()) || cnpj.getValor().isBlank()) {
            throw new IllegalArgumentException("O CNPJ do restaurante é obrigatório.");
        }

        if (Objects.isNull(nome) || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do restaurante é obrigatório.");
        }

        if (Objects.isNull(tipoCozinha) || tipoCozinha.isEmpty()) {
            throw new IllegalArgumentException("O tipo de cozinha é obrigatório e deve conter pelo menos um valor.");
        }

        if (Objects.isNull(horariosFuncionamento) || horariosFuncionamento.isEmpty()) {
            throw new IllegalArgumentException("Os horários de funcionamento são obrigatórios e devem conter pelo menos um horário.");
        }

        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade do restaurante deve ser um valor positivo.");
        }
    }
}