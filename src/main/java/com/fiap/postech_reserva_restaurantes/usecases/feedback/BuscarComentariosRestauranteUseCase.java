package com.fiap.postech_reserva_restaurantes.usecases.feedback;

import com.fiap.postech_reserva_restaurantes.dto.FeedbackDTO;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarComentariosRestauranteUseCase {


    private IFeedbackGateway feedbackGateway;
    @Autowired
    public BuscarComentariosRestauranteUseCase(IFeedbackGateway feedbackGateway) {
        this.feedbackGateway = feedbackGateway;
    }

    public List<String> execute(String idRestaurante) {
        List<FeedbackEntity> feedbackEntities = feedbackGateway.buscarFeedbacksPorRestaurante(idRestaurante);

        return feedbackEntities.stream()
                .map(feedbackEntity -> feedbackEntity.getComentario().getTexto())
                .collect(Collectors.toList());
    }
}