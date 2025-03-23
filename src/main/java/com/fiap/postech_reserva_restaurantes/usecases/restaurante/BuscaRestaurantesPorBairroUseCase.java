package com.fiap.postech_reserva_restaurantes.usecases.restaurante;


import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaRestaurantesPorBairroUseCase {
	
    @Autowired
    public RestauranteGateway restauranteGateway;

    public List<RestauranteEntity> buscarRestaurantesPorBairro(String bairro) {
        try {
            return restauranteGateway.buscarRestaurantesPorBairro(bairro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar restaurantes pelo bairro: " + bairro, e);
        }
    }
}