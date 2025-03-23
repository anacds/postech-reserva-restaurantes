package com.fiap.postech_reserva_restaurantes.controller;

import com.fiap.postech_reserva_restaurantes.dto.RestauranteDTO;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurante")
public class RestauranteController {

//    @Autowired
//    private CadastroRestauranteUseCase cadastroRestauranteUseCase;
    @Autowired
    private AtualizacaoRestauranteUseCase atualizacaoRestauranteUseCase;
    @Autowired
    private DelecaoRestauranteUseCase delecaoRestauranteUseCase;
    @Autowired
    private BuscaRestaurantePorIdUseCase buscaRestaurantePorIdUseCase;
    @Autowired
    private BuscaRestaurantesUseCase buscaRestaurantesUseCase;
    @Autowired
    private BuscaRestaurantesPorBairroUseCase buscaRestaurantesPorBairroUseCase;
    @Autowired
    private BuscaRestaurantesPorNomeUseCase buscaRestaurantesPorNomeUseCase;
    @Autowired
    private BuscaRestaurantesPorTipoCozinhaUseCase buscaRestaurantesPorTipoCozinhaUseCase;


//    @PostMapping
//    @Transactional
//    public ResponseEntity<RestauranteEntity> cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
//        RestauranteEntity restaurante = cadastroRestauranteUseCase.cadastrarRestaurante(restauranteDTO);
//        return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
//    }

    @PutMapping
    @Transactional
    public ResponseEntity<RestauranteEntity> alterarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        RestauranteEntity restaurante = atualizacaoRestauranteUseCase.atualizarRestaurante(restauranteDTO);
        return new ResponseEntity<>(restaurante, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarRestaurante(@PathVariable String id){
        delecaoRestauranteUseCase.deletarRestaurante(id);
    }

    @GetMapping("/")
    public List<RestauranteEntity> buscarRestaurantes(){
        return buscaRestaurantesUseCase.buscarRestaurantes();
    }

    @GetMapping("/buscar-por-id")
    public Optional<RestauranteEntity> buscarRestaurantePorId(@RequestParam("id") String id){
        return buscaRestaurantePorIdUseCase.buscarRestaurantePorId(id);
    }

    @GetMapping("/buscar-por-bairro")
    public List<RestauranteEntity> buscarRestaurantesPorBairro(@RequestParam("bairro") String bairro){
        return buscaRestaurantesPorBairroUseCase.buscarRestaurantesPorBairro(bairro);
    }

    @GetMapping("/buscar-por-nome")
    public List<RestauranteEntity> buscarRestaurantesPorNome(@RequestParam("nome") String nome){
        return buscaRestaurantesPorNomeUseCase.buscarRestaurantesPorNome(nome);
    }

    @GetMapping("/buscar-por-tipo-cozinha")
    public List<RestauranteEntity> buscarRestaurantesPorTipoCozinha(@RequestParam("tipoCozinha") String tipoCozinha){
        return buscaRestaurantesPorTipoCozinhaUseCase.buscarRestaurantesPorTipoCozinha(tipoCozinha);
    }

}