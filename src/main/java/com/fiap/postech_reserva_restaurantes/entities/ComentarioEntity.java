package com.fiap.postech_reserva_restaurantes.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comentarios")
public class ComentarioEntity {
    @DBRef
    private RestauranteEntity restaurante;

    @DBRef
    private UsuarioEntity usuario;

    private String texto;

    public ComentarioEntity(RestauranteEntity restaurante, UsuarioEntity usuario, String texto) {
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.texto = texto;
    }

    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public String getTexto() {
        return texto;
    }
}
