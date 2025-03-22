package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestauranteRepository extends MongoRepository<RestauranteEntity, String> {

}