package com.fiap.postech_reserva_restaurantes.gateways;

import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.RestauranteRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IRestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteGateway implements IRestauranteGateway {

    @Autowired
    public RestauranteRepository restauranteRepository;

    private final MongoTemplate mongoTemplate;

    public RestauranteGateway(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public RestauranteEntity cadastrarRestaurante(RestauranteEntity restaurante){
        return restauranteRepository.save(restaurante);
    }

    @Override
    public RestauranteEntity buscarRestaurantePorId(String id){
        return null;
    }


    @Override
    public List<RestauranteEntity> buscarRestaurantesPorNome(String nome){
        return restauranteRepository.findRestauranteEntitiesByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<RestauranteEntity> buscarRestaurantesPorTipoCozinha(String tipoCozinha){
        return restauranteRepository.findRestauranteEntitiesByTipoCozinhaContainingIgnoreCase(tipoCozinha);
    }

    @Override
    public List<RestauranteEntity> buscarRestaurantesPorBairro(String bairro){
        return restauranteRepository.findRestauranteEntitiesByEndereco_Bairro(bairro);
    }

    @Override
    public List<RestauranteEntity> listarRestaurantes(){
        return restauranteRepository.findAll();
    }

    public void atualizarRestaurante(RestauranteEntity restaurante){
        restauranteRepository.save(restaurante);
    }

    @Override
    public void deletarRestaurante(String id){
        restauranteRepository.deleteRestauranteEntityById(id);
    }
}
