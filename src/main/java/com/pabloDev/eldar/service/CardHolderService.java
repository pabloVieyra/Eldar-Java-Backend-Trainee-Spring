package com.pabloDev.eldar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabloDev.eldar.persistence.entity.CardHolder;
import com.pabloDev.eldar.persistence.repository.CardHolderRepository;


@Service
public class CardHolderService {
	
	@Autowired
	private CardHolderRepository cardHolderRepository;
	
	public CardHolder  create (CardHolder cardHolder) {
		return cardHolderRepository.save(cardHolder);
	}
	
	public List<CardHolder> getAllCardHolder (){
		return cardHolderRepository.findAll();
	}
	
	public void delete (CardHolder  cardHolder) {
		cardHolderRepository.delete(cardHolder);
	}
	
	public Optional<CardHolder> findById (Long id) {
		return cardHolderRepository.findById(id);
	}

}
