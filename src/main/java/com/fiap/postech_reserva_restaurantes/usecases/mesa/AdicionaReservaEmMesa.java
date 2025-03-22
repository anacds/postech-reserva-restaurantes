package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public class AdicionaReservaEmMesa {

	public static void adicionaReservaEmMesa(ReservaEntity reserva, String idMesa) {
		MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(idMesa);
		
		mesa.getReservas().add(reserva);
		
		MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getNumero(), mesa.capacidade, mesa.getRestaurante().getId(), mesa.getReservas());
		AlteraMesaUseCase.alterarMesa(mesaDTO);
		
	}
}
