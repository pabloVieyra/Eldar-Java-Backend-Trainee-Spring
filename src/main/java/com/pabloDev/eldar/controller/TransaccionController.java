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
import com.pabloDev.eldar.persistence.entity.Marca;

//Esta es la clase Controller de el Transacciones(tambien conocida la capa mas proxima al usuario)
//Aqui implementamos las transacciones

@RestController
@RequestMapping ("/api/transaccion/")
public class TransaccionController {

	@Autowired
	private TransaccionService transaccionService;
	
	

	
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Transaccion>> listarTransaccionesPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(transaccionService.findById(id));
	}
	
	@GetMapping("{marca}/operation/{amount}")
    public ResponseEntity<Long> getcalcularTasa(@PathVariable String marca, @PathVariable int amount) {

		return ResponseEntity.ok(transaccionService.getcalcularTasa(marca, amount));
    }

}
