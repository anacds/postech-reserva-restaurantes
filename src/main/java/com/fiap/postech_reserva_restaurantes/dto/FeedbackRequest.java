package com.fiap.postech_reserva_restaurantes.dto;

public class FeedbackRequest {
    private String usuarioId;
    private String restauranteId;
    private Double nota;
    private String comentario;

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