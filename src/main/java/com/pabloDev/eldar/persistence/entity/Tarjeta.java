package com.pabloDev.eldar.persistence.entity;

import java.time.LocalDate;

//aqui va la capa de datos de Tarjeta

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroTarjeta;
	private LocalDate fechaDeVencimiento;
	@OneToOne
	@JoinColumn(name = "idMarca")
	private Marca marca;
	
	@OneToOne
	@JoinColumn(name = "idCardHolder")
	private CardHolder cardHolder;

	public Tarjeta(Long id, String numeroTarjeta, LocalDate fechaDeVencimiento, Marca marca, CardHolder cardHolder) {
		super();
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.marca = marca;
		this.cardHolder = cardHolder;
	}

	public Tarjeta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public CardHolder getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(CardHolder cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numeroTarjeta=" + numeroTarjeta + ", fechaDeVencimiento=" + fechaDeVencimiento
				+ ", marca=" + marca + ", cardHolder=" + cardHolder + "]";
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	

}
