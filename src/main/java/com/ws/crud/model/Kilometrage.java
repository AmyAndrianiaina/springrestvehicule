package com.ws.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "idvehicule")
	private int idVehicule;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "debut_km")
	private int debutKm;
	
	@Column(name = "fin_km")
	private int finKm;

	public Kilometrage() {
		super();
	}

	public Kilometrage(int idVehicule, Date date, int debutKm, int finKm) {
		super();
		this.idVehicule = idVehicule;
		this.date = date;
		this.debutKm = debutKm;
		this.finKm = finKm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDebutKm() {
		return debutKm;
	}

	public void setDebutKm(int debutKm) {
		this.debutKm = debutKm;
	}

	public int getFinKm() {
		return finKm;
	}

	public void setFinKm(int finKm) {
		this.finKm = finKm;
	}
}
