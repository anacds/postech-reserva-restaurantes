package com.fiap.postech_reserva_restaurantes.external.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public interface ReservaRepository extends MongoRepository<ReservaEntity, Long>{

}
