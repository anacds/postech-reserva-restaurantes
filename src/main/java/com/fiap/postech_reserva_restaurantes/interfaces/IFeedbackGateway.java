package com.fiap.postech_reserva_restaurantes.interfaces;

import java.util.List;
import com.fiap.postech_reserva_restaurantes.entities.FeedbackEntity;

public interface IFeedbackGateway {

    public FeedbackEntity criarFeedback(FeedbackEntity feedback);

    public FeedbackEntity obterPorId(String idFeedback);

    public List<FeedbackEntity> buscarFeedbacksPorRestaurante(String idRestaurante);

    public List<FeedbackEntity> buscarFeedbacksPorUsuario(String idUsuario);

    public FeedbackEntity alterarFeedback(FeedbackEntity feedback);

    public void excluirFeedback(String idFeedback);
}