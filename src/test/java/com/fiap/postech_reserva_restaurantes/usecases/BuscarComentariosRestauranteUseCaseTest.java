package com.fiap.postech_reserva_restaurantes.usecases;

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

        // Criando o endereço do restaurante
        EnderecoEntity enderecoRestaurante = new EnderecoEntity(
                "Rua Exemplo", "123", "Bairro Exemplo", "Cidade", "SP", "12345-678", "Complemento 1"
        );

        // Criando o CNPJ do restaurante
        CNPJEntity cnpj = new CNPJEntity("12345678000195");

        // Criando os comentários
        List<ComentarioEntity> comentarios = Arrays.asList(
                new ComentarioEntity(null, null, "Excelente restaurante!"),
                new ComentarioEntity(null, null, "Comida boa")
        );

        // Criando o horário de funcionamento
        HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity("SEGUNDA", "08:00", "18:00");

        // Criando o restaurante sem a nota inicialmente
        restaurante = new RestauranteEntity(
                "Restaurante XYZ",
                cnpj,
                enderecoRestaurante,
                null,  // Nota será adicionada depois
                comentarios,
                Arrays.asList("Italiana", "Japonesa"),
                Arrays.asList(horario),
                50
        );

        // Criando a nota e associando ao restaurante
        NotaEntity nota = new NotaEntity(restaurante, 4.5);  // Agora podemos criar a nota com o restaurante

        // Associando a nota ao restaurante
        restaurante.setNota(nota);

        // Criando o usuário
        EnderecoEntity enderecoUsuario = new EnderecoEntity(
                "Avenida Exemplo", "456", "Bairro Exemplo", "Cidade", "SP", "98765-432", "Complemento"
        );
        usuario = new UsuarioEntity("user123", "João Silva", new Cpf("12345678900"), LocalDate.of(1990, 5, 20),
                "(11) 98765-4321", enderecoUsuario);

        // Criando os comentários
        comentario1 = new ComentarioEntity(restaurante, usuario, "Excelente restaurante!1");
        comentario2 = new ComentarioEntity(restaurante, usuario, "Comida muito boa, mas o atendimento deixou a desejar.");

        // Criando o feedback
        FeedbackEntity feedback1 = new FeedbackEntity(usuario, restaurante, null, comentario1);
        FeedbackEntity feedback2 = new FeedbackEntity(usuario, restaurante, null, comentario2);

        List<FeedbackEntity> feedbacks = Arrays.asList(feedback1, feedback2);

        // Configurando o mock do feedbackGateway para retornar a lista de feedbacks
        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(feedbacks);
    }



    @Test
    void testBuscarComentarios() throws Exception {
        // Chamando o caso de uso
        List<String> comentarios = buscarComentariosRestauranteUseCase.execute("restauranteId");

        // Comentários esperados
        List<String> comentariosEsperados = Arrays.asList(
                comentario1.getTexto(),
                comentario2.getTexto()
        );

        // Convertendo o resultado para JSON e imprimindo
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(comentarios);
        System.out.println("Comentarios JSON: " + jsonResult);

        // Validando os resultados
        assertEquals(comentariosEsperados.size(), comentarios.size(), "O número de comentários não corresponde ao esperado");
        assertTrue(comentarios.containsAll(comentariosEsperados), "Os comentários retornados não correspondem aos esperados");
    }

    @Test
    void testBuscarComentariosVazio() throws Exception {
        // Simulando uma lista vazia de feedbacks
        when(feedbackGateway.buscarFeedbacksPorRestaurante("restauranteId")).thenReturn(Arrays.asList());

        // Chamando o caso de uso
        List<String> comentarios = buscarComentariosRestauranteUseCase.execute("restauranteId");


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(comentarios);
        System.out.println("Comentarios JSON: " + jsonResult);


        assertTrue(comentarios.isEmpty(), "A lista de comentários não deve conter nenhum item");
    }
}
