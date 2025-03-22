package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaRestaurantesPorTipoCozinhaUseCase {
    @Autowired
    public static RestauranteGateway restauranteGateway;

    public static List<RestauranteEntity> buscarRestaurantesPorTipoCozinha(String tipoCozinha) {
        try {
            return restauranteGateway.buscarRestaurantesPorTipoCozinha(tipoCozinha);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar restaurantes pelo tipo de cozinha: " + tipoCozinha, e);
        }
    }
}
