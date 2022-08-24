package com.pabloDev.eldar.controller;

import java.net.URI;

//Esta es la clase Controller de el Tarjeta(tambien conocida la capa mas proxima al usuario)


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

import com.pabloDev.eldar.persistence.entity.Tarjeta;
import com.pabloDev.eldar.service.TarjetaService;

@RestController
@RequestMapping ("/api/tarjeta/")
public class TarjetaController {
	
	@Autowired
	private TarjetaService tarjetaService;
	
	@PostMapping
	private ResponseEntity<Tarjeta> guardar (@RequestBody Tarjeta tarjeta){
		Tarjeta temporal = tarjetaService.create(tarjeta);
		
		try {
			return ResponseEntity.created(new URI("/api/tarjeta"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Tarjeta>> listarTodasLasTarjetas (){
		return ResponseEntity.ok(tarjetaService.getAllTarjetas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarTarjeta (@RequestBody Tarjeta tarjeta){
		tarjetaService.delete(tarjeta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Tarjeta>> listarTarjetasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(tarjetaService.findById(id));
	}

}
