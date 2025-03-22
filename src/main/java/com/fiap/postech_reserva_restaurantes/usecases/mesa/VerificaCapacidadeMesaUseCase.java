package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

public class VerificaCapacidadeMesaUseCase {

	@Autowired
	public static MesaGateway mesaGateway;
	
	public static List<MesaEntity> verificar(List<MesaEntity> mesas, ReservaEntity reserva){
	
		List<MesaEntity> mesasComCapacidade =  
				mesas.stream().filter(x -> x.getCapacidade() >= reserva.getQtdPessoas()).collect(Collectors.toList());
		
		return mesasComCapacidade;
	}
}
