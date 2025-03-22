package com.fiap.postech_reserva_restaurantes.usecases;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class CalculaMediaNotaUseCase {

    private IFeedbackGateway feedbackGateway;

    @Autowired
    public CalculaMediaNotaUseCase(IFeedbackGateway feedbackGateway) {
        this.feedbackGateway = feedbackGateway;
    }

    public FeedbackDTO execute(String idRestaurante) {
        List<FeedbackEntity> feedbackEntities = feedbackGateway.buscarFeedbacksPorRestaurante(idRestaurante);

        if (feedbackEntities.isEmpty()) {
            throw new IllegalArgumentException("Nenhum feedback encontrado para este restaurante.");
        }

        double somaNotas = 0;
        for (FeedbackEntity feedback : feedbackEntities) {
            somaNotas += feedback.getNota().getValor();
        }

        double media = somaNotas / feedbackEntities.size();
        return new FeedbackDTO(null, null, idRestaurante, media, null);
    }


}
