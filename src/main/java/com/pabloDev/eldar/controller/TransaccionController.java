package com.pabloDev.eldar.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabloDev.eldar.persistence.entity.Transaccion;
import com.pabloDev.eldar.service.TransaccionService;



@RestController
@RequestMapping ("/api/transaccion/")
public class TransaccionController {

	@Autowired
	private TransaccionService transaccionService;
	
	@PostMapping
	private ResponseEntity<Transaccion> guardar (@RequestBody Transaccion transaccion){
		Transaccion temporal = transaccionService.create(transaccion);
		
		try {
			return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Transaccion>> listarTodasLasPersona (){
		return ResponseEntity.ok(transaccionService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody Transaccion transaccion){
		transaccionService.delete(transaccion);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Transaccion>> listarTarjetasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(transaccionService.findById(id));
	}

}
