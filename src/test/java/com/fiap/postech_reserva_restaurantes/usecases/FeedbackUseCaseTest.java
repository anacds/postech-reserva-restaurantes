package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.external.repositories.FeedbackRepository;
import com.fiap.postech_reserva_restaurantes.external.repositories.UsuarioRepository;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.FeedbackUseCase;
import com.fiap.postech_reserva_restaurantes.external.repositories.RestauranteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackUseCaseTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackUseCase feedbackUseCase;

    private UsuarioEntity usuario;
    private RestauranteEntity restaurante;
    private NotaEntity nota;
    private ComentarioEntity comentario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


        usuario = mock(UsuarioEntity.class);
        restaurante = mock(RestauranteEntity.class);
        nota = mock(NotaEntity.class);
        comentario = mock(ComentarioEntity.class);


        HorarioFuncionamentoEntity horario = new HorarioFuncionamentoEntity("SEGUNDA", "08:00", "18:00");


        when(restauranteRepository.findById("restauranteId")).thenReturn(java.util.Optional.of(restaurante));
        when(restaurante.getHorariosFuncionamento()).thenReturn(Arrays.asList(horario));


        when(usuarioRepository.findById("usuarioId")).thenReturn(java.util.Optional.of(usuario));
        when(feedbackRepository.save(any(FeedbackEntity.class))).thenReturn(new FeedbackEntity(usuario, restaurante, nota, comentario));
    }

    @Test
    public void testCriarFeedback() throws Exception {

        FeedbackEntity feedback = feedbackUseCase.criarFeedback("usuarioId", "restauranteId", 4.5, "Excelente restaurante!");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(feedback);

        System.out.println("Feedback JSON: " + jsonResult);

        assertNotNull(feedback);
        assertEquals(usuario, feedback.getUsuario());
        assertEquals(restaurante, feedback.getRestaurante());
        assertEquals(nota, feedback.getNota());
        assertEquals(comentario, feedback.getComentario());

        verify(usuarioRepository).findById("usuarioId");
        verify(restauranteRepository).findById("restauranteId");
        verify(feedbackRepository).save(any(FeedbackEntity.class));
    }
}
