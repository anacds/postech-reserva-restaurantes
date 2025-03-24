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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.fiap.postech_reserva_restaurantes.dto.MesaDTO;
import com.fiap.postech_reserva_restaurantes.entities.MesaEntity;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AdicionaMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.AlteraMesaUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesaPorIdUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.mesa.BuscarMesasPorRestaurante;
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
	@Autowired
	private BuscarMesasPorRestaurante buscarMesasPorRestaurante;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<MesaEntity> adicionaMesaUseCase(@RequestBody MesaDTO mesaDTO){
		MesaEntity mesa = adicionaMesaUseCase.adicionarMesa(mesaDTO);
		return new ResponseEntity<> (mesa, HttpStatus.CREATED);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<MesaEntity> alteraMesaUseCase(@RequestBody MesaDTO mesaDTO){
		MesaEntity mesa = alteraMesaUseCase.alterarMesa(mesaDTO);
		return new ResponseEntity<> (mesa, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletaMesaUseCase(@PathVariable String id){
		deletaRegistroMesaUseCase.deletarMesa(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	 public MesaEntity buscarMesaPorId(@RequestParam("id") String id){
		MesaEntity mesa = buscarMesaPorIdUseCase.buscar(id);
		return mesa;	
	 }
	
	@GetMapping("/por-restaurante")
	 public List<MesaEntity> buscarMesaPorRestaurante(@RequestParam("id_restaurante") String id){
		List<MesaEntity> mesas = buscarMesasPorRestaurante.buscar(id);
		return mesas;
	 }
}
