package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.CalculaMediaNotaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculaMediaNotaUseCaseTest {

    @InjectMocks
    private CalculaMediaNotaUseCase calculaMediaNotaUseCase;

    @Mock
    private IFeedbackGateway feedbackGateway;

    @Test
    void testCalculaMediaNota() {

        CNPJEntity cnpj = new CNPJEntity("12.345.678/0001-90");


        EnderecoEntity endereco = new EnderecoEntity(
                "Rua Fictícia", "123", "Bairro Fictício", "Cidade Fictícia",
                "SP", "12345-678", "Complemento"
        );


        String diaDaSemana = "SEGUNDA";
        String horarioAbertura = "08:00";
        String horarioFechamento = "18:00";

        HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity(diaDaSemana, horarioAbertura, horarioFechamento);


        RestauranteEntity restaurante = new RestauranteEntity(
                "Restaurante Fictício", cnpj, endereco, 0.0, Collections.emptyList(),
                Arrays.asList("Italiana", "Vegetariana"), Arrays.asList(horario), 100
        );


        NotaEntity nota1 = new NotaEntity(restaurante, 5.0);
        NotaEntity nota2 = new NotaEntity(restaurante, 5.0);
        NotaEntity nota3 = new NotaEntity(restaurante, 1.0);
        FeedbackEntity feedback1 = new FeedbackEntity(null, null, nota1, null);
        FeedbackEntity feedback2 = new FeedbackEntity(null, null, nota2, null);
        FeedbackEntity feedback3 = new FeedbackEntity(null, null, nota3, null);
        List<FeedbackEntity> feedbacks = Arrays.asList(feedback1, feedback2, feedback3);


        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(feedbacks);


        double resultado = calculaMediaNotaUseCase.execute("restauranteId");


        System.out.println("Média calculada: " + resultado);


        double somaNotas = feedbacks.stream()
                .mapToDouble(f -> f.getNota().getValor())
                .sum();
        double mediaEsperada = somaNotas / feedbacks.size();

        assertEquals(mediaEsperada, resultado, 0.1);
    }
}
