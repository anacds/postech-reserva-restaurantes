package com.fiap.postech_reserva_restaurantes.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;

public interface IReservaGateway {
	
	public ReservaEntity criarReserva(ReservaEntity reserva);
	
	public List<ReservaEntity> procurarReservasPorUsuario(ReservaEntity reserva);
	
	public List<ReservaEntity> procurarReservasPorRestaurante(ReservaEntity reserva);
	
	public void atualizar(ReservaEntity reserva);
	
	public void cancelar(ReservaEntity reserva);
	
	
}
