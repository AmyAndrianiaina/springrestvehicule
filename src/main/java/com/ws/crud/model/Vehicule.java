package com.ws.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "couleur")
	private String couleur;
	
	@Column(name = "km")
	private int km;
	
	@Column(name = "numero")
	private String numero;
	
	public Vehicule() {
		super();
	}
	
	public Vehicule(String marque, String model, String couleur, int km, String numero) {
		super();
		this.marque = marque;
		this.model = model;
		this.couleur = couleur;
		this.km = km;
		this.numero = numero;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
