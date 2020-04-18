package com.dreamseeker.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tasas")
public class Tasa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private float tasaPromedio;
	private float tasaMinima;
	private float tasaMaxima;
	
	public float getTasaPromedio() {
		return tasaPromedio;
	}
	public void setTasaPromedio(float tasaPromedio) {
		this.tasaPromedio = tasaPromedio;
	}
	public float getTasaMinima() {
		return tasaMinima;
	}
	public void setTasaMinima(float tasaMinima) {
		this.tasaMinima = tasaMinima;
	}
	public float getTasaMaxima() {
		return tasaMaxima;
	}
	public void setTasaMaxima(float tasaMaxima) {
		this.tasaMaxima = tasaMaxima;
	}

}
