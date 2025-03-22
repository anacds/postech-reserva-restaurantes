package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DelecaoRestauranteUseCase {

    @Autowired
    public RestauranteGateway restauranteGateway;

    public void deletarRestaurante(String id) {
        try {
                restauranteGateway.deletarRestaurante(id);
            } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o restaurante com ID " + id, e);
        }

    }
}
