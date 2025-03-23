package com.fiap.postech_reserva_restaurantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AdicionaMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AlteraMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.DeletaRegistroMesaUseCase;

@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	private AdicionaMesaUseCase adicionaMesaUseCase;
	@Autowired
	private AlteraMesaUseCase alteraMesaUseCase;
	@Autowired
	private DeletaRegistroMesaUseCase deletaRegistroMesaUseCase;
	@Autowired
	private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
	
	@PostMapping
	@Transactional
	public MesaEntity adicionaMesaUseCase(@RequestBody MesaDTO mesaDTO){
		MesaEntity mesa = adicionaMesaUseCase.adicionarMesa(mesaDTO);
		return mesa;
	}
	
	@PutMapping
	@Transactional
	public MesaEntity alteraMesaUseCase(@RequestBody MesaDTO mesaDTO){
		MesaEntity mesa = alteraMesaUseCase.alterarMesa(mesaDTO);
		return mesa;
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity deletaMesaUseCase(String id){
		deletaRegistroMesaUseCase.deletarMesa(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	 public MesaEntity buscarMesaPorId(@RequestParam("id") String id, UriComponentsBuilder uriBuilder){
		MesaEntity mesa = buscarMesaPorIdUseCase.buscar(id);
		return mesa;
	 }
}
