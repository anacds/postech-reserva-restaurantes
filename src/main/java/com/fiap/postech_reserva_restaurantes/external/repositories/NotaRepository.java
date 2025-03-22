package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.NotaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotaRepository extends MongoRepository<NotaEntity, String> {
}