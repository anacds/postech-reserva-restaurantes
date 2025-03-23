package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<FeedbackEntity, String> {
    List<FeedbackEntity> findByRestauranteId(String restauranteId);
}