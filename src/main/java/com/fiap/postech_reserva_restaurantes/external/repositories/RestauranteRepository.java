package com.fiap.postech_reserva_restaurantes.external.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;

import java.util.List;

public interface RestauranteRepository extends MongoRepository<RestauranteEntity, Long>{

    List<RestauranteEntity> findRestauranteEntitiesByNomeContainingIgnoreCase(String nome);

    List<RestauranteEntity> findRestauranteEntitiesByTipoCozinhaContainingIgnoreCase(String tipoCozinha);

    void deleteRestauranteEntityById(String id);

    List<RestauranteEntity> findRestauranteEntitiesByEndereco_Bairro(String enderecoBairro);
}