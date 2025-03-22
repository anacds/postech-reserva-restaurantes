package com.fiap.postech_reserva_restaurantes.gateways;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.FeedbackRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IFeedbackGateway;

@Service
public class FeedbackGateway implements IFeedbackGateway {

    @Autowired
    private FeedbackRepository feedbackRepository;

    private final MongoTemplate mongoTemplate;

    public FeedbackGateway(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public FeedbackEntity criarFeedback(FeedbackEntity feedback) {
        return feedbackRepository.save(feedback);
    }

    public FeedbackEntity obterPorId(String id) {
        return feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback não encontrado"));
    }

    public List<FeedbackEntity> buscarFeedbacksPorRestaurante(String idRestaurante) {
        return feedbackRepository.findByRestauranteId(idRestaurante);
    }

    public List<FeedbackEntity> buscarFeedbacksPorUsuario(String idUsuario) {
        Query query = new Query(Criteria.where("usuario_id").is(idUsuario));
        return mongoTemplate.find(query, FeedbackEntity.class);
    }

    public FeedbackEntity alterarFeedback(FeedbackEntity feedback) {
        return feedbackRepository.save(feedback);
    }

    public void excluirFeedback(String idFeedback) {
        feedbackRepository.deleteById(idFeedback);
    }
}