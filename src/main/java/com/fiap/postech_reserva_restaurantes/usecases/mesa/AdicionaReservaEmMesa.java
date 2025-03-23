package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.Objects;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;

public class AdicionaReservaEmMesa {

	public static void adicionaReservaEmMesa(ReservaEntity reserva, String idMesa) { 
		
		try {
		
		MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(idMesa);
		
		if (Objects.isNull(mesa)) {
			throw new Exception("Essa mesa não existe.");
		}
		
		mesa.getReservas().add(reserva);
		
		MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getNumero(), mesa.capacidade, mesa.getRestaurante().getId(), mesa.getReservas());
		
		AlteraMesaUseCase.alterarMesa(mesaDTO);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
