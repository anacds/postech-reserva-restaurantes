package com.fiap.postech_reserva_restaurantes.dto;

import java.time.LocalDateTime;


public record ReservaDTO (
		String id,
		String idMesa, String idUsuario, String  idRestaurante,
		LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String status,
		String observacao, int qtdPessoas
		){
	
		
	}
