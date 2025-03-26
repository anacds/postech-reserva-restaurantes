package com.fiap.postech_reserva_restaurantes.usecases.mesa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.entities.RestauranteEntity;
import com.fiap.postech_reserva_restaurantes.gateways.MesaGateway;
import com.fiap.postech_reserva_restaurantes.usecases.restaurante.BuscaRestaurantePorIdUseCase;

@Service
public class VerificaMesasDisponiveisPorHorario {
	
	@Autowired
	public MesaGateway mesaGateway;
	
	@Autowired
	private BuscarMesasPorRestaurante buscarMesasPorRestaurante;
	
	@Autowired
	private BuscaRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
	
	public List<MesaEntity> verifica(String idRestaurante, LocalDateTime dataInicio, LocalDateTime dataFim) {
		
		Optional<RestauranteEntity> restaurante = buscarRestaurantePorIdUseCase.buscarRestaurantePorId(idRestaurante);
		
		List<MesaEntity> mesasDesseRestaurante = buscarMesasPorRestaurante.buscar(restaurante.get().getId());
		
		List<MesaEntity> mesasDisponiveisHorario = new ArrayList<MesaEntity>();
		
		for(MesaEntity mesa : mesasDesseRestaurante) {
			List<ReservaEntity> reservasDaMesa = mesa.getReservas();
			
			if (reservasDaMesa.size() == 0) {
				mesasDisponiveisHorario.add(mesa);
			}
			else {
				List<ReservaEntity> reservasNesseHorario = reservasDaMesa.stream()
					.filter(x -> validaDisponibilidade(dataInicio, dataFim, x.getDataHoraInicio(), x.getDataHoraFim())).collect(Collectors.toList());
				
				if (Objects.isNull(reservasNesseHorario)) {
					mesasDisponiveisHorario.add(mesa);
				}
			}
		}
		
		return mesasDisponiveisHorario;
		
	}
	
	private boolean validaDisponibilidade(LocalDateTime horarioInicioDesejado, LocalDateTime horarioFimDesejado, 
			LocalDateTime horarioInicioExistente, LocalDateTime horarioFimExistente
			) {
		
		if(!horarioInicioExistente.getMonth().equals(horarioInicioDesejado.getMonth())) {
			return true;
		}
	
		if (horarioInicioExistente.isBefore(horarioInicioDesejado) ) {
			if (horarioFimExistente.isBefore(horarioInicioDesejado)) {
				return true;
			} 
		}
			
		if (horarioInicioExistente.isAfter(horarioInicioDesejado)) {
			if (horarioFimDesejado.isBefore(horarioInicioExistente)) {
				return true;
			}
		}
		
		return false;
		
	}
	
}