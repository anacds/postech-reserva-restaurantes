package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaRestaurantePorIdUseCase {

    @Autowired
    public static RestauranteGateway restauranteGateway;

    public static Optional<RestauranteEntity> buscarRestaurantePorId(String id) {
        try {
            return restauranteGateway.buscarRestaurantePorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar restaurante com ID: " + id, e);
        }
    }
}
