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



@RestController
@RequestMapping ("/api/cardholder/")
public class CardHolderController {
	
	@Autowired
	private CardHolderService cardHolderService;
	
	@PostMapping
	private ResponseEntity<CardHolder> guardar (@RequestBody CardHolder cardHolder){
		CardHolder temporal = cardHolderService.create(cardHolder);
		
		try {
			return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<CardHolder>> listarTodasLasPersona (){
		return ResponseEntity.ok(cardHolderService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody  CardHolder cardHolder){
		cardHolderService.delete(cardHolder);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<CardHolder>> listarTarjetasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(cardHolderService.findById(id));
	}

}
