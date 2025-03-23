package com.fiap.postech_reserva_restaurantes.usecases;
/*
import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.CalculaMediaNotaUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculaMediaNotaUseCaseTest {

    @InjectMocks
    private CalculaMediaNotaUseCase calculaMediaNotaUseCase;

    @Mock
    private IFeedbackGateway feedbackGateway;

    @Test
    void testCalculaMediaNota() throws Exception {

        CNPJEntity cnpj = new CNPJEntity("12.345.678/0001-90");


        EnderecoEntity endereco = new EnderecoEntity(
                "Rua Fictícia",    // Rua
                "123",             // Número
                "Bairro Fictício", // Bairro
                "Cidade Fictícia", // Cidade
                "SP",              // Estado
                "12345-678",       // CEP
                "Complemento"      // Complemento
        );


        DiaDaSemana diaDaSemana = DiaDaSemana.SEGUNDA;
        LocalDateTime horarioAbertura = LocalDateTime.of(2025, 3, 22, 8, 0, 0, 0);
        LocalDateTime horarioFechamento = LocalDateTime.of(2025, 3, 22, 18, 0, 0, 0);

        HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity(diaDaSemana, horarioAbertura, horarioFechamento);


        RestauranteEntity restaurante = new RestauranteEntity(
                "Restaurante Fictício",
                cnpj,
                endereco,
                null,
                Collections.emptyList(),
                Arrays.asList("Italiana", "Vegetariana"),
                Arrays.asList(horario),
                100
        );


        NotaEntity nota1 = new NotaEntity(restaurante, 4.0);
        NotaEntity nota2 = new NotaEntity(restaurante, 3.0);
        FeedbackEntity feedback1 = new FeedbackEntity(null, null, nota1, null);
        FeedbackEntity feedback2 = new FeedbackEntity(null, null, nota2, null);
        List<FeedbackEntity> feedbacks = Arrays.asList(feedback1, feedback2);


        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(feedbacks);


        FeedbackDTO resultado = calculaMediaNotaUseCase.execute("restauranteId");


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(resultado);


        System.out.println("Resultado JSON: " + jsonResult);


        assertEquals(3.5, resultado.getNota(), 0.1);
    }
}
*/