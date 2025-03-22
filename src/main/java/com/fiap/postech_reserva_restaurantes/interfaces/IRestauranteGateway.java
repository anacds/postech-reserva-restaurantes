package com.fiap.postech_reserva_restaurantes.interfaces;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;

import java.util.List;

public interface IRestauranteGateway {

    public RestauranteEntity cadastrarRestaurante(RestauranteEntity restaurante);

    public RestauranteEntity buscarRestaurantePorId(String id);

    public List<RestauranteEntity> buscarRestaurantesPorNome(String nome);

    public List<RestauranteEntity> buscarRestaurantesPorTipoCozinha(String tipoCozinha);

    public List<RestauranteEntity> buscarRestaurantesPorBairro(String bairro);

    public List<RestauranteEntity> listarRestaurantes();

    public void atualizarRestaurante(RestauranteEntity restaurante);

    public void deletarRestaurante(String id);
}
