package com.fiap.postech_reserva_restaurantes.interfaces;

import java.util.List;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;

public interface IMesaGateway {
	
	public MesaEntity criarMesa(MesaEntity mesa);
	
	public MesaEntity obterPorId(Long idMesa);
	
	public List<MesaEntity> buscarMesasPorRestaurante(Long idRestaurante);
	
	public MesaEntity alterarMesa(MesaEntity mesa);
	
	public void excluirMesa(Long idMesa);
	
}
