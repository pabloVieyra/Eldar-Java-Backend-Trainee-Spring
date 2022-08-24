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

import com.pabloDev.eldar.persistence.entity.CardHolder;
import com.pabloDev.eldar.service.CardHolderService;

//Esta es la clase Controller de el CardHome(tambien conocida la capa mas proxima al usuario)

@RestController
@RequestMapping ("/api/cardholder/")
public class CardHolderController {
	
	@Autowired
	private CardHolderService cardHolderService;
	
	@PostMapping
	private ResponseEntity<CardHolder> guardar (@RequestBody CardHolder cardHolder){
		CardHolder temporal = cardHolderService.create(cardHolder);
		
		try {
			return ResponseEntity.created(new URI("/api/cardgolder"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<CardHolder>> listarTodasLoscardHolder (){
		return ResponseEntity.ok(cardHolderService.getAllCardHolder());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarCardHolder(@RequestBody  CardHolder cardHolder){
		cardHolderService.delete(cardHolder);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<CardHolder>> listarCardHolderPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(cardHolderService.findById(id));
	}

}
