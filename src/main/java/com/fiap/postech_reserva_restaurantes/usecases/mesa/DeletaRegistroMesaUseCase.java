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
	public static MesaGateway mesaGateway;
	
	public static void deletarMesa(MesaDTO mesaDTO) {
		try {
			MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(mesaDTO.id());
			
			// Se tiver algum registro associado à essa lista, significa que essa mesa está sendo reservada, 
			// então não pode ser excluída
			if (!Objects.isNull(mesa.getReservas())) {
				System.out.println("Mesa não pode ser excluída.");
			}else {
				mesaGateway.excluirMesa(mesa.getId());;
			}
			
		} catch (Exception e) {
			System.out.println("Mesa não pode ser excluída.");
		}
	}

}
