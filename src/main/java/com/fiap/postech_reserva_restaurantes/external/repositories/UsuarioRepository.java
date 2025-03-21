package com.fiap.postech_reserva_restaurantes.external.repositories;

import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByCpf(Cpf cpf);
    List<UsuarioEntity> findAll();
}
