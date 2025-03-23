package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class VerificaCapacidadeMesaUseCase {

	@Autowired
	public MesaGateway mesaGateway;
	
	public List<MesaEntity> verificar(List<MesaEntity> mesas, int qtdPessoasReserva){
	
		List<MesaEntity> mesasComCapacidade =  
				mesas.stream().filter(x -> x.getCapacidade() >= qtdPessoasReserva).collect(Collectors.toList());
		
		return mesasComCapacidade;
	}
}
