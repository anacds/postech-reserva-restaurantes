package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelecaoRestauranteUseCase {

    @Autowired
    public static RestauranteGateway restauranteGateway;

    public static void deletarRestaurante(String id) {
        try {
            RestauranteEntity restaurante = restauranteGateway.buscarRestaurantePorId(id);
            if (restaurante != null) {
                restauranteGateway.deletarRestaurante(restaurante);
            } else {
                throw new IllegalArgumentException("Restaurante com ID " + id + " não foi encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o restaurante com ID " + id, e);
        }
    }
}
