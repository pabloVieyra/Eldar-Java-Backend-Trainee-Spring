package com.pabloDev.eldar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabloDev.eldar.persistence.entity.Transaccion;



public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{

}
