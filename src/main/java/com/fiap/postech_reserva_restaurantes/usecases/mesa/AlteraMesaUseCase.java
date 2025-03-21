package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class AlteraMesaUseCase {
	
	@Autowired
	public  MesaGateway mesaGateway;
	
	@Autowired
	private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
	
	public MesaEntity alterarMesa(MesaDTO mesaDTO) {
		
		try {
			MesaEntity mesa = buscarMesaPorIdUseCase.buscar(mesaDTO.id());
			return mesaGateway.alterarMesa(mesa);
			
		} catch (Exception e) {
			System.out.println("Mesa não foi alterada");
			return null;
		}
	}

}