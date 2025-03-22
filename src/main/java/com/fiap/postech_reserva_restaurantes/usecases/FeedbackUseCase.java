package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.entities.*;
import com.fiap.postech_reserva_restaurantes.external.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class FeedbackUseCase {

    private final FeedbackRepository feedbackRepository;
    private final UsuarioRepository usuarioRepository;
    private final RestauranteRepository restauranteRepository;
    private final NotaRepository notaRepository;

    public FeedbackUseCase(FeedbackRepository feedbackRepository, UsuarioRepository usuarioRepository, RestauranteRepository restauranteRepository, NotaRepository notaRepository) {
        this.feedbackRepository = feedbackRepository;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
        this.notaRepository = notaRepository;
    }

    public FeedbackEntity criarFeedback(String usuarioId, String restauranteId, Double notaValor, String comentarioTexto) {
        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        RestauranteEntity restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));


        NotaEntity nota = new NotaEntity(restaurante, notaValor);
        ComentarioEntity comentario = new ComentarioEntity(restaurante, usuario, comentarioTexto);

        FeedbackEntity feedback = new FeedbackEntity(usuario, restaurante, nota, comentario);
        return feedbackRepository.save(feedback);
    }
}