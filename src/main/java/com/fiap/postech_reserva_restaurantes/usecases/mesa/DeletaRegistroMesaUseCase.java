package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class DeletaRegistroMesaUseCase {
	
	@Autowired
	public MesaGateway mesaGateway;

	@Autowired
	private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
	
	public void deletarMesa(String idMesa) {
		try {
			MesaEntity mesa = buscarMesaPorIdUseCase.buscar(idMesa);
			
			// Se tiver algum registro associado à essa lista, significa que essa mesa está sendo reservada, 
			// então não pode ser excluída
			if (mesa.getReservas().size() < 0) {
				System.out.println("Mesa não pode ser excluída.");
			}else {
				mesaGateway.excluirMesa(mesa.getId());;
			}
			
		} catch (Exception e) {
			System.out.println("Mesa não pode ser excluída.");
		}
	}

}
