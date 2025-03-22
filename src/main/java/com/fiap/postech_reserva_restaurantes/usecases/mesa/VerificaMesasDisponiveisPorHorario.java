package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;

@Service
public class VerificaMesasDisponiveisPorHorario {
	
	@Autowired
	public static MesaGateway mesaGateway;
	
	public static List<MesaEntity> verifica(String idRestaurante, LocalDateTime dataInicio, LocalDateTime dataFim) {
		
//		RestauranteEntity restaurante = new RestauranteEntity();
//		
//		List<MesaEntity> mesasDesseRestaurante = BuscarMesasPorRestaurante.buscar(restaurante.getId());
//		
		List<MesaEntity> mesasDisponiveisHorario = new ArrayList<MesaEntity>();
		
//		for(MesaEntity mesa : mesasDesseRestaurante) {
//			List<ReservaEntity> reservasDaMesa = mesa.getReservas();
//			
//			List<ReservaEntity> reservasNesseHorario = reservasDaMesa.stream()
//				.filter(x ->
//						x.getDataHoraInicio().isBefore(null) &&
//						x.getDataHoraFim().isBefore(null)).collect(Collectors.toList());
//			
//			if (Objects.isNull(reservasNesseHorario)) {
//				mesasDisponiveisHorario.add(mesa);
//			}
//			
//		}
//		
		return mesasDisponiveisHorario;
		
	}
}