package com.fiap.postech_reserva_restaurantes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document(collection = "notas")
public class NotaEntity {

    @Id
    private String id;
    private RestauranteEntity restaurante;
    private Double valor;

    public NotaEntity(RestauranteEntity restaurante, Double valor) {
        validarRestaurante(restaurante);
        validarNota(valor);

        this.restaurante = restaurante;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public Double getValor() {
        return valor;
    }

    private void validarRestaurante(RestauranteEntity restaurante) {
        if (Objects.isNull(restaurante)) {
            throw new IllegalArgumentException("Restaurante não pode ser nulo.");
        }
    }

    private void validarNota(Double valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Nota não pode ser nula.");
        }
        if (valor < 0 || valor > 5) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 5.");
        }
    }
}

