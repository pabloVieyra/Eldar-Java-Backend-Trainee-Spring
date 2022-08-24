package com.pabloDev.eldar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabloDev.eldar.persistence.entity.CardHolder;

public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {

}
