package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.dto.RestauranteDTO;
import com.fiap.postech_reserva_restaurantes.entities.CNPJEntity;
import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.RestauranteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizacaoRestauranteUseCase {

    @Autowired
    public static RestauranteGateway restauranteGateway;

    public static RestauranteEntity atualizarRestaurante(RestauranteDTO restauranteDTO) {
        return null;
    }

    private static void validarDadosRestaurante(RestauranteEntity restaurante) {
        if (restaurante.getNome() == null || restaurante.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do restaurante é obrigatório.");
        }
        if (restaurante.getCnpj() == null || restaurante.getCnpj().getValor().isBlank()) {
            throw new IllegalArgumentException("CNPJ do restaurante é obrigatório.");
        }
        if (restaurante.getEndereco() == null) {
            throw new IllegalArgumentException("Endereço do restaurante é obrigatório.");
        }
        if (restaurante.getTipoCozinha() == null || restaurante.getTipoCozinha().isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um tipo de cozinha deve ser informado.");
        }
        if (restaurante.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do restaurante deve ser maior que zero.");
        }
    }
}