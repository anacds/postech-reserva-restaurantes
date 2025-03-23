package com.fiap.postech_reserva_restaurantes.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public interface IReservaGateway {
	
	public void criarReserva(ReservaEntity reserva);
	
	public List<ReservaEntity> buscarReservasPorUsuario(String idUsuario);
	
	public List<ReservaEntity> buscarReservasPorRestaurante(String idRestaurante);
	
	public ReservaEntity buscaReservaPorId(String idReserva);
	
	public ReservaEntity alterarReserva(ReservaEntity reserva);
	
	public void excluirReserva(String idReserva);
	
}
