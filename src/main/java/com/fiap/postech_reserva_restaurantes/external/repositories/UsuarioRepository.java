package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

}