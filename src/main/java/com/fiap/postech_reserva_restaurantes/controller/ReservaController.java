package com.fiap.postech_reserva_restaurantes.controller;

import java.util.List;
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
	private AlteraReservaUseCase alteraReservaUseCase;
	@Autowired
	private CancelaReservaUseCase cancelaReservaUseCase;
	@Autowired
	private BuscaReservaPorIdUseCase buscaReservaPorIdUseCase;
	@Autowired
	private BuscaReservasPorRestauranteUseCase buscaReservasPorRestauranteUseCase;
	@Autowired
	private BuscaReservasPorUsuarioUseCase buscaReservasPorUsuarioUseCase;

	
	 @PostMapping
	 @Transactional
	 public ReservaEntity criarReserva(@RequestBody ReservaDTO reservaDTO) {
		 ReservaEntity reserva = efetuaReservaUseCase.reservarMesa(reservaDTO);
		 return reserva;
	 }
	 
	 @PutMapping
	 @Transactional
	 public ReservaEntity alterarReserva(@RequestBody ReservaDTO reservaDTO){
		 ReservaEntity reserva = alteraReservaUseCase.alterar(reservaDTO);
		 return reserva;
	 }
	 
	 @DeleteMapping("/{id}")
	 @Transactional
	 public ReservaEntity cancelarReserva(@PathVariable String id){
		 ReservaEntity reserva = cancelaReservaUseCase.cancelar(id);
		 return reserva;
	 }
	 
	 @GetMapping("/buscar-por-id")
	 public ReservaEntity buscarReservaPorId(@RequestParam("id") String id, UriComponentsBuilder uriBuilder){
		ReservaEntity reserva = buscaReservaPorIdUseCase.buscar(id);
		return reserva;
	 }
	 
	 @GetMapping("/buscar-por-restaurante")
	 public List<ReservaEntity> buscarReservaPorRestaurante(@RequestParam("id") String id, UriComponentsBuilder uriBuilder){
		List<ReservaEntity> reservas = buscaReservasPorRestauranteUseCase.buscar(id);
		return reservas;
	 }
	 
	 @GetMapping("/buscar-por-usuario")
	 public List<ReservaEntity> buscarReservaPorUsuario(@RequestParam("id") String id, UriComponentsBuilder uriBuilder){
		List<ReservaEntity> reservas = buscaReservasPorUsuarioUseCase.buscar(id);
		return reservas;
	 }
}
