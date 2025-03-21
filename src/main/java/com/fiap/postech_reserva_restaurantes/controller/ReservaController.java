package com.fiap.postech_reserva_restaurantes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.usecases.ReservaMesaUseCase;

@Controller
public class ReservaController {

	private ReservaMesaUseCase reservaMesaUseCase;
	
	  @PostMapping
	    @Transactional
	    public ResponseEntity<ReservaEntity> criarReserva(/*@RequestBody*/ ReservaDTO reservaDTO) {
	    	
	    	ReservaEntity reserva = reservaMesaUseCase.reservarMesa(reservaDTO);
	        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
	    }

}
