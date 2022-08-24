package com.pabloDev.eldar.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabloDev.eldar.persistence.entity.Tarjeta;
import com.pabloDev.eldar.persistence.entity.Transaccion;
import com.pabloDev.eldar.persistence.repository.TransaccionRepository;

//aqui va la capa de la logica de negocios

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
	
	
	
	public Optional<Transaccion> findById (Long id) {
		return transaccionRepository.findById(id);
	}
	
	//Calculos de tasa
	
	public long getcalcularTasa (String marca, long importe) {
		long tasa = 0;

		switch (marca) {

		case "visa": {

			System.out.println("Usted eligio la opcion visa.");
			tasa = (importe / 100) * (LocalDate.now().getYear() / LocalDate.now().getMonthValue());

			break;

		}

		case "Nara": {

			System.out.println("Usted eligio la opcion Nara.");
			tasa = (long) ((importe / 100) * (0.5 * LocalDate.now().getDayOfMonth()));

			break;
		}

		case "Amex": {

			System.out.println("Usted eligio la opcion Amex.");
			tasa = (long) ((importe / 100) * (0.1 * LocalDate.now().getMonthValue()));

			break;
		}

		default: {
			System.out.println("Opcion incorrecta, esa marca no trabajamos actualmente");
		}
		}// cierra SWITCH
		return tasa;
	}

}
