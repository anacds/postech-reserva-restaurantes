package com.fiap.postech_reserva_restaurantes.usecases.restaurante;

import com.fiap.postech_reserva_restaurantes.dto.RestauranteDTO;
import com.fiap.postech_reserva_restaurantes.entities.CNPJEntity;
import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.HorarioFuncionamentoEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroRestauranteUseCase {

    public static RestauranteEntity cadastrarRestaurante(RestauranteDTO restauranteDTO) {
        if (restauranteDTO == null) {
            throw new IllegalArgumentException("Dados do restaurante não podem ser nulos.");
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

        // fazer o mesmo pra nota
        // fazer o mesmo pra comentários

        RestauranteEntity restaurante = new RestauranteEntity(
                restauranteDTO.nome(),
                cnpj,
                endereco,
                null,  // ajustar
                null,  // ajustar
                restauranteDTO.tipoCozinha(),
                horariosFuncionamento,
                restauranteDTO.capacidade()
        );

        try {
			validarDadosRestaurante(restaurante);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurante;
    }

private static void validarDadosRestaurante(RestauranteEntity restaurante) throws Exception {
    if (restaurante.getNome() == null || restaurante.getNome().isBlank()) {
        throw new Exception("Nome do restaurante é obrigatório.");
    }
    if (restaurante.getCnpj() == null || restaurante.getCnpj().getValor().isBlank()) {
        throw new Exception("CNPJ do restaurante é obrigatório.");
    }
    if (restaurante.getEndereco() == null) {
        throw new Exception("Endereço do restaurante é obrigatório.");
    }
    if (restaurante.getTipoCozinha() == null || restaurante.getTipoCozinha().isEmpty()) {
        throw new Exception("Pelo menos um tipo de cozinha deve ser informado.");
    }
    if (restaurante.getCapacidade() <= 0) {
        throw new Exception("Capacidade do restaurante deve ser maior que zero.");
    }
}
}
