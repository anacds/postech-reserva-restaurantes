package com.fiap.postech_reserva_restaurantes.interfaces;

import java.util.List;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public interface IReservaGateway {
	
	public void criarReserva(ReservaEntity reserva);
	
	public List<ReservaEntity> buscarReservasPorUsuario(Long idUsuario);
	
	public List<ReservaEntity> buscarReservasPorRestaurante(Long idRestaurante);
	
	public ReservaEntity buscaReservaPorId(Long idReserva);
	
	public void alterarReserva(ReservaEntity reserva);
	
	public void excluirReserva(Long idReserva);
	
}
