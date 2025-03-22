package com.fiap.postech_reserva_restaurantes.gateways;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.ReservaRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IReservaGateway;

@Service
public class ReservaGateway implements IReservaGateway{

	@Autowired
	private ReservaRepository reservaRepository;

	private final MongoTemplate mongoTemplate;
	
	public ReservaGateway(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void criarReserva(ReservaEntity reserva) {
		reservaRepository.save(reserva);
	}

	public List<ReservaEntity> buscarReservasPorUsuario(String idUsuario) {
		Query query = new Query(Criteria.where("usuario_id").is(idUsuario));
		return mongoTemplate.find(query, ReservaEntity.class);
	}

	public List<ReservaEntity> buscarReservasPorRestaurante(String idRestaurante) {
		Query query = new Query(Criteria.where("restaurante_id").is(idRestaurante));
		return mongoTemplate.find(query, ReservaEntity.class);
	}

	public ReservaEntity buscaReservaPorId(String idReserva) {
		return reservaRepository.findById(idReserva).orElseThrow(() -> new IllegalArgumentException("Reserva não cadastrada"));
	}

	public void alterarReserva(ReservaEntity reserva) {
		reservaRepository.save(reserva);
	}

	public void excluirReserva(String idReserva) {
		reservaRepository.deleteById(idReserva);
	}


}
