package com.fiap.postech_reserva_restaurantes.controller;

import com.fiap.postech_reserva_restaurantes.dto.RestauranteDTO;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("restaurante")
public class RestauranteController {

    @PostMapping
    @Transactional
    public ResponseEntity<RestauranteEntity> cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        RestauranteEntity restaurante = CadastroRestauranteUseCase.cadastrarRestaurante(restauranteDTO);
        return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<RestauranteEntity> alterarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        RestauranteEntity restaurante = AtualizacaoRestauranteUseCase.atualizarRestaurante(restauranteDTO);
        return new ResponseEntity<>(restaurante, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarRestaurante(@PathVariable String id){
        DelecaoRestauranteUseCase.deletarRestaurante(id);
    }

    @GetMapping("/")
    public List<RestauranteEntity> buscarRestaurantes(){
        return BuscaRestaurantesUseCase.buscarRestaurantes();
    }

    @GetMapping("/buscar-por-id")
    public Optional<RestauranteEntity> buscarRestaurantePorId(@RequestParam("id") String id){
        return BuscaRestaurantePorIdUseCase.buscarRestaurantePorId(id);
    }

    @GetMapping("/buscar-por-bairro")
    public List<RestauranteEntity> buscarRestaurantesPorBairro(@RequestParam("bairro") String bairro){
        return BuscaRestaurantesPorBairroUseCase.buscarRestaurantesPorBairro(bairro);
    }

    @GetMapping("/buscar-por-nome")
    public List<RestauranteEntity> buscarRestaurantesPorNome(@RequestParam("nome") String nome){
        return BuscaRestaurantesPorNomeUseCase.buscarRestaurantesPorNome(nome);
    }

    @GetMapping("/buscar-por-tipo-cozinha")
    public List<RestauranteEntity> buscarRestaurantesPorTipoCozinha(@RequestParam("tipoCozinha") String tipoCozinha){
        return BuscaRestaurantesPorTipoCozinhaUseCase.buscarRestaurantesPorTipoCozinha(tipoCozinha);
    }

}