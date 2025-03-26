/*package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.BuscarComentariosRestauranteUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BuscarComentariosRestauranteUseCaseTest {

    @Mock
    private IFeedbackGateway feedbackGateway;

    @InjectMocks
    private BuscarComentariosRestauranteUseCase buscarComentariosRestauranteUseCase;

    private RestauranteEntity restaurante;
    private UsuarioEntity usuario;
    private ComentarioEntity comentario1;
    private ComentarioEntity comentario2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        EnderecoEntity enderecoRestaurante = new EnderecoEntity(
                "Rua Exemplo",  // rua
                "123",          // numero
                "Bairro Exemplo",  // bairro
                "Cidade",       // cidade
                "SP",           // estado
                "12345-678",    // cep
                "Complemento 1" // complemento
        );

        CNPJEntity cnpj = new CNPJEntity("12345678000195");
        List<ComentarioEntity> comentarios = Arrays.asList(
                new ComentarioEntity(null, null, "Excelente restaurante!"),
                new ComentarioEntity(null, null, "Comida boa")
        );

        restaurante = new RestauranteEntity("Restaurante XYZ", cnpj, enderecoRestaurante, null, comentarios, null, null, 50);

        NotaEntity nota = new NotaEntity(restaurante, 4.5);

        restaurante = new RestauranteEntity("Restaurante XYZ", cnpj, enderecoRestaurante, nota, comentarios, null, null, 50);

        EnderecoEntity enderecoUsuario = new EnderecoEntity(
                "Avenida Exemplo", "456", "Bairro Exemplo", "Cidade", "SP", "98765-432", "Complemento"
        );
        usuario = new UsuarioEntity("user123", "João Silva", new Cpf("12345678900"), LocalDate.of(1990, 5, 20), "(11) 98765-4321", enderecoUsuario);

        comentario1 = new ComentarioEntity(restaurante, usuario, "Excelente restaurante!");
        comentario2 = new ComentarioEntity(restaurante, usuario, "Comida muito boa, mas o atendimento deixou a desejar.");

        FeedbackEntity feedback1 = new FeedbackEntity(usuario, restaurante, null, comentario1);
        FeedbackEntity feedback2 = new FeedbackEntity(usuario, restaurante, null, comentario2);

        List<FeedbackEntity> feedbacks = Arrays.asList(feedback1, feedback2);

        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(feedbacks);
    }

    @Test
    void testBuscarComentarios() throws Exception {

        List<String> comentarios = buscarComentariosRestauranteUseCase.execute("restauranteId");


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(comentarios);


        System.out.println("Comentarios JSON: " + jsonResult);

        assertEquals(2, comentarios.size());
        assertTrue(comentarios.contains("Excelente restaurante!"));
        assertTrue(comentarios.contains("Comida muito boa, mas o atendimento deixou a desejar."));
    }

    @Test
    void testBuscarComentariosVazio() throws Exception {

        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(Arrays.asList());

        List<String> comentarios = buscarComentariosRestauranteUseCase.execute("restauranteId");


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(comentarios);


        System.out.println("Comentarios JSON: " + jsonResult);

        assertTrue(comentarios.isEmpty());
    }
}
*/