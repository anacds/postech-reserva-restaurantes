package com.fiap.postech_reserva_restaurantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.postech_reserva_restaurantes.dto.ReservaDTO;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.AlteraReservaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.BuscaReservaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.BuscaReservasPorRestauranteUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.BuscaReservasPorUsuarioUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.CancelaReservaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.reserva.EfetuaReservaUseCase;

@Controller
@RequestMapping("reserva")
public class ReservaController {

	@Autowired
	private EfetuaReservaUseCase efetuaReservaUseCase;
	
	@Autowired
	private CancelaReservaUseCase cancelaReservaUseCase;
	
	@Autowired
	private AlteraReservaUseCase alteraReservaUseCase;
	
	@Autowired
	private BuscaReservaPorIdUseCase buscaReservaPorIdUseCase;
	
	@Autowired
	private BuscaReservasPorRestauranteUseCase buscaReservasPorRestauranteUseCase;
	
	@Autowired
	private BuscaReservasPorUsuarioUseCase buscaReservasPorUsuarioUseCase;
	
	 @PostMapping
	 @Transactional
	 public ResponseEntity<ReservaEntity> criarReserva(@RequestBody ReservaDTO reservaDTO) {
		 ReservaEntity reserva = efetuaReservaUseCase.reservarMesa(reservaDTO);
		 return new ResponseEntity<>(reserva, HttpStatus.CREATED);
	 }
	 
	 @PutMapping
	 @Transactional
	 public ResponseEntity<ReservaEntity> alterarReserva(@RequestBody ReservaDTO reservaDTO){
		 ReservaEntity reserva = alteraReservaUseCase.alterar(reservaDTO);
		 return new ResponseEntity<ReservaEntity>(reserva, HttpStatus.ACCEPTED);
	 }
	 
	 @DeleteMapping("/{id}")
	 @Transactional
	 public ResponseEntity<ReservaEntity> cancelarReserva(@PathVariable Long id){
		 ReservaEntity reserva = cancelaReservaUseCase.cancelar(id);
		 return new ResponseEntity<ReservaEntity>(reserva, HttpStatus.ACCEPTED);
	 }
	 
	 @GetMapping("/buscar-por-id")
	 public ResponseEntity<ReservaEntity> buscarReservaPorId(@RequestParam("id") Long id, UriComponentsBuilder uriBuilder){
		ReservaEntity reserva = buscaReservaPorIdUseCase.buscar(id);
		var uri = uriBuilder.path("/reserva/buscar-por-id/{id}").buildAndExpand(reserva.getId()).toUri();
		return ResponseEntity.created(uri).body(reserva);
	 }
	 
	 @GetMapping("/buscar-por-restaurante")
	 public ResponseEntity<ReservaEntity> buscarReservaPorRestaurante(@RequestParam("id") Long id, UriComponentsBuilder uriBuilder){
		ReservaEntity reserva = buscaReservasPorRestauranteUseCase.buscar(id);
		var uri = uriBuilder.path("/reserva/buscar-por-restaurante/{id}").buildAndExpand(reserva.getId()).toUri();
		return ResponseEntity.created(uri).body(reserva);
	 }
	 
	 @GetMapping("/buscar-por-usuario")
	 public ResponseEntity<ReservaEntity> buscarReservaPorUsuario(@RequestParam("id") Long id, UriComponentsBuilder uriBuilder){
		ReservaEntity reserva = buscaReservasPorUsuarioUseCase.buscar(id);
		var uri = uriBuilder.path("/reserva/buscar-por-usuario/{id}").buildAndExpand(reserva.getId()).toUri();
		return ResponseEntity.created(uri).body(reserva);
	 }
}
