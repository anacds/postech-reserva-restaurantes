package com.fiap.postech_reserva_restaurantes.dto;

public class FeedbackDTO {
    private String id;
    private String usuarioId;
    private String restauranteId;
    private Double nota;
    private String comentario;


    public FeedbackDTO(String id, String usuarioId, String restauranteId, Double nota, String comentario) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.restauranteId = restauranteId;
        this.nota = nota;
        this.comentario = comentario;
    }


    public String getId() {
        return id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getRestauranteId() {
        return restauranteId;
    }

    public Double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }
}