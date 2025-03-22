package com.fiap.postech_reserva_restaurantes.gateways;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.MesaRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IMesaGateway;

@Service
public class MesaGateway implements IMesaGateway{
	
	@Autowired
	private MesaRepository mesaRepository;
	
	private final MongoTemplate mongoTemplate;
	
	public MesaGateway(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public MesaEntity obterPorId(String id) {
		return mesaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Mesa não existe"));
	}

	public MesaEntity criarMesa(MesaEntity mesa) {
		return mesaRepository.save(mesa);
	}

	public List<MesaEntity> buscarMesasPorRestaurante(String idRestaurante) {
		Query query = new Query(Criteria.where("restaurante_id").is(idRestaurante));
		return mongoTemplate.find(query, MesaEntity.class);
	}

	public MesaEntity alterarMesa(MesaEntity mesa) {
		return mesaRepository.save(mesa);
	}

	public void excluirMesa(String idMesa) {
		mesaRepository.deleteById(idMesa);
	}


}
