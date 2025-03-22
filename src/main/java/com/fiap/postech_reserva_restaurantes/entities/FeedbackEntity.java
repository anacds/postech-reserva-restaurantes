package com.fiap.postech_reserva_restaurantes.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "feedbacks")
public class FeedbackEntity {

    @Id
    private String id;

    @DBRef
    private UsuarioEntity usuario;

    @DBRef
    private RestauranteEntity restaurante;

    private NotaEntity nota;
    private ComentarioEntity comentario;

    @CreatedDate
    private LocalDateTime dataCriacao;

    public FeedbackEntity(UsuarioEntity usuario, RestauranteEntity restaurante, NotaEntity nota, ComentarioEntity comentario) {
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public NotaEntity getNota() {
        return nota;
    }

    public ComentarioEntity getComentario() {
        return comentario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}