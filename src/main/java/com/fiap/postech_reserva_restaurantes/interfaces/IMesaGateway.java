package com.fiap.postech_reserva_restaurantes.interfaces;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;

public interface IMesaGateway {
	public MesaEntity obterPorId(Long id);
}
