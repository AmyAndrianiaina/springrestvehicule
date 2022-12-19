package com.ws.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "idTerrain")
    private int idTerrain;
	
    @Column(name = "x")
    private int x;
    
    @Column(name = "y")
    private int y;
    
    @Column(name = "vatoKg")
    private double vatoKg;
    
    @Column(name = "volamenaKg")
    private double volamenaKg;
    
    @Column(name = "heureTotal")
    private int heureTotal;
    
    @Column(name = "pourcentage")
    private double pourcentage;
    
    @Column(name = "performanceParHeure")
    private double performanceParHeure;

	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(int idTerrain, int x, int y, double vatoKg, double volamenaKg, int heureTotal, double pourcentage,
			double performanceParHeure) {
		super();
		this.idTerrain = idTerrain;
		this.x = x;
		this.y = y;
		this.vatoKg = vatoKg;
		this.volamenaKg = volamenaKg;
		this.heureTotal = heureTotal;
		this.pourcentage = pourcentage;
		this.performanceParHeure = performanceParHeure;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdTerrain() {
		return idTerrain;
	}

	public void setIdTerrain(int idTerrain) {
		this.idTerrain = idTerrain;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getVatoKg() {
		return vatoKg;
	}

	public void setVatoKg(double vatoKg) {
		this.vatoKg = vatoKg;
	}

	public double getVolamenaKg() {
		return volamenaKg;
	}

	public void setVolamenaKg(double volamenaKg) {
		this.volamenaKg = volamenaKg;
	}

	public int getHeureTotal() {
		return heureTotal;
	}

	public void setHeureTotal(int heureTotal) {
		this.heureTotal = heureTotal;
	}

	public double getPourcentage() {
		this.pourcentage = (this.volamenaKg / this.vatoKg) * 100;
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = (this.volamenaKg / this.vatoKg) * 100;
	}

	public double getPerformanceParHeure() {
		this.performanceParHeure = this.vatoKg / this.heureTotal;
		return performanceParHeure;
	}

	public void setPerformanceParHeure(double performanceParHeure) {
		this.performanceParHeure = this.vatoKg / this.heureTotal;
	}
}
