package com.fiap.postech_reserva_restaurantes.usecases.feedback;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculaMediaNotaUseCase {

    private IFeedbackGateway feedbackGateway;

    @Autowired
    public CalculaMediaNotaUseCase(IFeedbackGateway feedbackGateway) {
        this.feedbackGateway = feedbackGateway;
    }


    public double execute(String idRestaurante) {
        List<FeedbackEntity> feedbackEntities = feedbackGateway.buscarFeedbacksPorRestaurante(idRestaurante);

        if (feedbackEntities.isEmpty()) {
            throw new IllegalArgumentException("Nenhum feedback encontrado para este restaurante.");
        }

        return feedbackEntities.stream()
                .mapToDouble(feedback -> feedback.getNota().getValor())
                .average()
                .orElse(0.0);
    }

}
