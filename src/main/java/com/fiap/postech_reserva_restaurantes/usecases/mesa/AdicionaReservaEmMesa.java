package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
@Service
public class AdicionaReservaEmMesa {

	@Autowired
	private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
	
	@Autowired
	private AlteraMesaUseCase alteraMesaUseCase;
	
	public void adicionaReservaEmMesa(ReservaEntity reserva, String idMesa) { 
		
		try {
		
		MesaEntity mesa = buscarMesaPorIdUseCase.buscar(idMesa);
		
		if (Objects.isNull(mesa)) {
			throw new Exception("Essa mesa não existe.");
		}
		
		mesa.getReservas().add(reserva);
		
		MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getNumero(), mesa.capacidade, mesa.getRestaurante().getId(), mesa.getReservas());
		
		alteraMesaUseCase.alterarMesa(mesaDTO);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
