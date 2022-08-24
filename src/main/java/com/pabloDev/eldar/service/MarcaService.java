package com.pabloDev.eldar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabloDev.eldar.persistence.entity.Marca;
import com.pabloDev.eldar.persistence.repository.MarcaRepository;




@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public Marca  create (Marca marca) {
		return marcaRepository.save(marca);
	}
	
	public List<Marca> getAllMarcas (){
		return marcaRepository.findAll();
	}
	
	public void delete (Marca  marca) {
		marcaRepository.delete(marca);
	}
	
	public Optional<Marca> findById (Long id) {
		return marcaRepository.findById(id);
	}

}
