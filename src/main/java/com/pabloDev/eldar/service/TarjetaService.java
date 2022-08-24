package com.pabloDev.eldar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabloDev.eldar.persistence.entity.Tarjeta;
import com.pabloDev.eldar.persistence.repository.TarjetaRepository;

@Service
public class TarjetaService {
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	public Tarjeta create (Tarjeta tarjeta) {
		return tarjetaRepository.save(tarjeta);
	}
	
	public List<Tarjeta> getAllTarjetas (){
		return tarjetaRepository.findAll();
	}
	
	public void delete (Tarjeta tarjeta) {
		tarjetaRepository.delete(tarjeta);
	}
	
	public Optional<Tarjeta> findById (Long id) {
		return tarjetaRepository.findById(id);
	}

}
