package com.fiap.postech_reserva_restaurantes.controller;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackRequest;
import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.BuscarComentariosRestauranteUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.BuscarFeedbackPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.CalculaMediaNotaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.feedback.FeedbackUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackUseCase feedbackUseCase;
    private final CalculaMediaNotaUseCase calculaMediaNotaUseCase;
    private final BuscarComentariosRestauranteUseCase buscarComentariosRestauranteUseCase;
    private final BuscarFeedbackPorIdUseCase buscarFeedbackPorIdUseCase;

    public FeedbackController(FeedbackUseCase feedbackUseCase,
                              CalculaMediaNotaUseCase calculaMediaNotaUseCase,
                              BuscarComentariosRestauranteUseCase buscarComentariosRestauranteUseCase,
                              BuscarFeedbackPorIdUseCase buscarFeedbackPorIdUseCase) {
        this.feedbackUseCase = feedbackUseCase;
        this.calculaMediaNotaUseCase = calculaMediaNotaUseCase;
        this.buscarComentariosRestauranteUseCase = buscarComentariosRestauranteUseCase;
        this.buscarFeedbackPorIdUseCase = buscarFeedbackPorIdUseCase;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> criarFeedback(@RequestBody FeedbackRequest request) {

        FeedbackEntity feedbackEntity = feedbackUseCase.criarFeedback(request.getUsuarioId(), request.getRestauranteId(), request.getNota(), request.getComentario());


        FeedbackDTO feedbackDTO = new FeedbackDTO(feedbackEntity.getId(), feedbackEntity.getUsuario().getId(),
                feedbackEntity.getRestaurante().getId(), feedbackEntity.getNota().getValor(), feedbackEntity.getComentario().getTexto());


        return ResponseEntity.status(201).body(feedbackDTO);
    }

    @GetMapping("/media/{idRestaurante}")
    public ResponseEntity<Double> calcularMediaNota(@PathVariable String idRestaurante) {
        double mediaNota = calculaMediaNotaUseCase.execute(idRestaurante);
        return ResponseEntity.ok(mediaNota);
    }

    @GetMapping("/comentarios/{idRestaurante}")
    public ResponseEntity<List<String>> buscarComentarios(@PathVariable String idRestaurante) {
        List<String> comentarios = buscarComentariosRestauranteUseCase.execute(idRestaurante);
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackEntity> buscarFeedbackPorId(@PathVariable String id) {
        Optional<FeedbackEntity> feedback = buscarFeedbackPorIdUseCase.execute(id);
        return feedback.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}

