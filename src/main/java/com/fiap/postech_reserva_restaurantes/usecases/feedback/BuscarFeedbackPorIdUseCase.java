package com.fiap.postech_reserva_restaurantes.usecases.feedback;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarFeedbackPorIdUseCase {

    private final FeedbackRepository feedbackRepository;

    public BuscarFeedbackPorIdUseCase(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Optional<FeedbackEntity> execute(String id) {
        return feedbackRepository.findById(id);
    }
}
