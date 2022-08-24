package com.pabloDev.eldar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabloDev.eldar.persistence.entity.Transaccion;
import com.pabloDev.eldar.persistence.repository.TransaccionRepository;


@Service
public class TransaccionService {
	
	@Autowired
	private TransaccionRepository transaccionRepository;
	
	public Transaccion create (Transaccion transaccion) {
		return transaccionRepository.save(transaccion);
	}
	
	public List<Transaccion> getAllPersonas (){
		return transaccionRepository.findAll();
	}
	
	public void delete (Transaccion transaccion) {
		transaccionRepository.delete(transaccion);
	}
	
	public Optional<Transaccion> findById (Long id) {
		return transaccionRepository.findById(id);
	}

}
