package com.pabloDev.eldar.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Marca;
	
	public Marca(Long id, String marca) {
		super();
		this.id = id;
		Marca = marca;
	}

	public Marca() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", Marca=" + Marca + "]";
	}
	
	
	
	
	
	

}
