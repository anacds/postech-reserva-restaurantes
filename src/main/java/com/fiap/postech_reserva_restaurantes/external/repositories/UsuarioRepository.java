package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

    @Query("{ 'cpf.value' : ?0 }")
    Optional<UsuarioEntity> findByCpf(String cpf);

    List<UsuarioEntity> findAll();
}
