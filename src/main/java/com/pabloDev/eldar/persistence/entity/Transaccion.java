package com.pabloDev.eldar.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "transaccion")
public class Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double importe;
	@OneToOne
	@JoinColumn(name = "idMarca")
	private Marca marca;
	
	
	public Transaccion(Long id, Double importe, Marca marca) {
		super();
		this.id = id;
		this.importe = importe;
		this.marca = marca;
	}
	

	public Transaccion() {
		super();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	
	
}
