package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.external.repositories.FeedbackRepository;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.BuscarFeedbackPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarFeedbackPorIdUseCaseTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private BuscarFeedbackPorIdUseCase buscarFeedbackPorIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarFeedbackQuandoIdExistir() {

        CNPJEntity cnpj = new CNPJEntity("12345678000195");
        EnderecoEntity endereco = new EnderecoEntity("Av. Paulista", "1000", "Bairro", "São Paulo", "SP", "12345-678", "Bloco A");

        HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity("SEGUNDA", "08:00", "18:00");

        RestauranteEntity restaurante = new RestauranteEntity(
                "Restaurante XPTO",
                cnpj,
                endereco,
                null,
                null,
                Arrays.asList("Italiana", "Vegetariana"),
                Arrays.asList(horario),
                50
        );

        NotaEntity nota = new NotaEntity(restaurante, 4.5);

        EnderecoEntity enderecoUsuario = new EnderecoEntity("Rua A", "123", "Centro", "São Paulo", "SP", "12345-678", "Apto 101");
        Cpf cpf = new Cpf("12345678900");
        UsuarioEntity usuario = new UsuarioEntity(
                "1",
                "João Silva",
                cpf,
                java.time.LocalDate.of(1990, 5, 10),
                "11987654321",
                enderecoUsuario
        );

        String comentarioTexto = "Excelente restaurante!";

        ComentarioEntity comentario = new ComentarioEntity(restaurante, usuario, comentarioTexto);

        FeedbackEntity feedback = new FeedbackEntity(usuario, restaurante, nota, comentario);

        when(feedbackRepository.findById(anyString())).thenReturn(Optional.of(feedback));

        Optional<FeedbackEntity> resultado = buscarFeedbackPorIdUseCase.execute("123");

        assertTrue(resultado.isPresent());

        double notaEsperada = resultado.get().getNota().getValor();
        String comentarioEsperado = resultado.get().getComentario().getTexto();

        assertEquals(notaEsperada, resultado.get().getNota().getValor());
        assertEquals(comentarioEsperado, resultado.get().getComentario().getTexto());


        System.out.println("Feedback encontrado: " + resultado.get().getComentario().getTexto());
        verify(feedbackRepository, times(1)).findById(anyString());
    }



    @Test
    void deveRetornarVazioQuandoIdNaoExistir() {

        String feedbackId = "999";
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());

        Optional<FeedbackEntity> resultado = buscarFeedbackPorIdUseCase.execute(feedbackId);

        assertFalse(resultado.isPresent());
        verify(feedbackRepository, times(1)).findById(feedbackId);
    }
}
