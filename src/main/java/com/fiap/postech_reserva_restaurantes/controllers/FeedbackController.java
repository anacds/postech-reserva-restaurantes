package com.fiap.postech_reserva_restaurantes.controllers;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackRequest;
import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.usecases.CalculaMediaNotaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.BuscarComentariosRestauranteUseCase;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.usecases.FeedbackUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackUseCase feedbackUseCase;
    private final CalculaMediaNotaUseCase calculaMediaNotaUseCase;
    private final BuscarComentariosRestauranteUseCase buscarComentariosRestauranteUseCase;

    public FeedbackController(FeedbackUseCase feedbackUseCase,
                              CalculaMediaNotaUseCase calculaMediaNotaUseCase,
                              BuscarComentariosRestauranteUseCase buscarComentariosRestauranteUseCase) {
        this.feedbackUseCase = feedbackUseCase;
        this.calculaMediaNotaUseCase = calculaMediaNotaUseCase;
        this.buscarComentariosRestauranteUseCase = buscarComentariosRestauranteUseCase;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> criarFeedback(@RequestBody FeedbackRequest request) {

        FeedbackEntity feedbackEntity = feedbackUseCase.criarFeedback(request.getUsuarioId(), request.getRestauranteId(), request.getNota(), request.getComentario());


        FeedbackDTO feedbackDTO = new FeedbackDTO(feedbackEntity.getId(), feedbackEntity.getUsuario().getId(),
                feedbackEntity.getRestaurante().getId(), feedbackEntity.getNota().getValor(), feedbackEntity.getComentario().getTexto());


        return ResponseEntity.status(201).body(feedbackDTO);
    }

    @GetMapping("/media/{idRestaurante}")
    public ResponseEntity<FeedbackDTO> calcularMediaNota(@PathVariable String idRestaurante) {
        FeedbackDTO feedbackDTO = calculaMediaNotaUseCase.execute(idRestaurante);
        return ResponseEntity.ok(feedbackDTO);
    }

    @GetMapping("/comentarios/{idRestaurante}")
    public ResponseEntity<List<String>> buscarComentarios(@PathVariable String idRestaurante) {
        List<String> comentarios = buscarComentariosRestauranteUseCase.execute(idRestaurante);
        return ResponseEntity.ok(comentarios);
    }
}