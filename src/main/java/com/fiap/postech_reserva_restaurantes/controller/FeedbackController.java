package com.fiap.postech_reserva_restaurantes.controller;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackRequest;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.FeedbackUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackUseCase feedbackUseCase;

    public FeedbackController(FeedbackUseCase feedbackUseCase) {
        this.feedbackUseCase = feedbackUseCase;
    }

    @PostMapping
    public ResponseEntity<FeedbackEntity> criarFeedback(@RequestBody FeedbackRequest request) {
        FeedbackEntity feedback = feedbackUseCase.criarFeedback(request.getUsuarioId(), request.getRestauranteId(), request.getNota(), request.getComentario());
        return ResponseEntity.ok(feedback);
    }
}