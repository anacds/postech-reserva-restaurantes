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
import java.util.Optional;

@Service
public class AtualizacaoRestauranteUseCase {

    @Autowired
    public RestauranteGateway restauranteGateway;

    public RestauranteEntity atualizarRestaurante(RestauranteDTO restauranteDTO) {
        if (restauranteDTO == null) {
            throw new IllegalArgumentException("Dados do restaurante não podem ser nulos.");
        }

        Optional<RestauranteEntity> restauranteExistente = restauranteGateway.buscarRestaurantePorId(restauranteDTO.id());
        if (restauranteExistente.isEmpty()) {
            throw new IllegalArgumentException("Restaurante não encontrado para atualização.");
        }

        CNPJEntity cnpj = new CNPJEntity(restauranteDTO.cnpj());

        EnderecoEntity endereco = new EnderecoEntity(
                restauranteDTO.endereco().rua(),
                restauranteDTO.endereco().numero(),
                restauranteDTO.endereco().bairro(),
                restauranteDTO.endereco().cidade(),
                restauranteDTO.endereco().estado(),
                restauranteDTO.endereco().cep(),
                restauranteDTO.endereco().complemento()
        );

        List<HorarioFuncionamentoEntity> horariosFuncionamento = new ArrayList<>();
        for (var horarioDTO : restauranteDTO.horariosFuncionamento()) {
            HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity(
                    horarioDTO.diaSemana(),
                    horarioDTO.horarioAbertura(),
                    horarioDTO.horarioFechamento()
            );
            horariosFuncionamento.add(horario);
        }

        RestauranteEntity restauranteAtualizado = new RestauranteEntity(
                restauranteDTO.nome(),
                cnpj,
                endereco,
                restauranteExistente.get().getNota(),
                restauranteExistente.get().getComentarios(),
                restauranteDTO.tipoCozinha(),
                horariosFuncionamento,
                restauranteDTO.capacidade()
        );

        validarDadosRestaurante(restauranteAtualizado);

        return restauranteGateway.atualizarRestaurante(restauranteAtualizado);
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