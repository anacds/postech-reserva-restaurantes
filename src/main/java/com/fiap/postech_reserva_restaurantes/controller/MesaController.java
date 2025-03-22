package com.fiap.postech_reserva_restaurantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AdicionaMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AlteraMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.DeletaRegistroMesaUseCase;

@Controller
@RequestMapping("mesa")
public class MesaController {
	
	@PostMapping
	@Transactional
	public ResponseEntity<MesaEntity> adicionaMesaUseCase(MesaDTO mesaDTO){
		MesaEntity mesa = AdicionaMesaUseCase.adicionarMesa(mesaDTO);
		return new ResponseEntity<>(mesa, HttpStatus.CREATED);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<MesaEntity> alteraMesaUseCase(MesaDTO mesaDTO){
		MesaEntity mesa = AlteraMesaUseCase.alterarMesa(mesaDTO);
		return new ResponseEntity<>(mesa, HttpStatus.OK);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity deletaMesaUseCase(MesaDTO mesaDTO){
		DeletaRegistroMesaUseCase.deletarMesa(mesaDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	 public ResponseEntity<MesaEntity> buscarReservaPorUsuario(@RequestParam("id") String id, UriComponentsBuilder uriBuilder){
		MesaEntity mesa = BuscarMesaPorIdUseCase.buscar(id);
		var uri = uriBuilder.path("/mesa/{id}").buildAndExpand(mesa.getId()).toUri();
		return ResponseEntity.created(uri).body(mesa);
	 }
}
