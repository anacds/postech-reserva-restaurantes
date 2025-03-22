package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaRestaurantesUseCase {
    @Autowired
    public static RestauranteGateway restauranteGateway;

    public static List<RestauranteEntity> buscarRestaurantes() {
        try {
            return restauranteGateway.listarRestaurantes();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar restaurantes. ", e);
        }
    }
}
