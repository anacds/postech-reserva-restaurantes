package com.fiap.postech_reserva_restaurantes.external.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;

public interface MesaRepository extends MongoRepository<MesaEntity, Long>{

}
