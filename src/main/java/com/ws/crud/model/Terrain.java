package com.ws.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terrain")
public class Terrain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "pointDroiteHautX")
    private int pointDroiteHautX;
	
	@Column(name = "pointDroiteHautY")
    private int pointDroiteHautY;
	
	@Column(name = "pointDroiteBasX")
    private int pointDroiteBasX;
		
	@Column(name = "pointDroiteBasY")
    private int pointDroiteBasY;
	
	@Column(name = "pointGaucheHautX")
    private int pointGaucheHautX;
	
	@Column(name = "pointGaucheHautY")
    private int pointGaucheHautY;
	
	@Column(name = "pointGaucheBasX")
    private int pointGaucheBasX;
	
	@Column(name = "pointGaucheBasY")
    private int pointGaucheBasY;
	
	@Column(name = "area")
    private double area;
    
	public Terrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Terrain(int pointDroiteHautX, int pointDroiteHautY, int pointDroiteBasX, int pointDroiteBasY,
			int pointGaucheHautX, int pointGaucheHautY, int pointGaucheBasX, int pointGaucheBasY, double area) {
		super();
		this.pointDroiteHautX = pointDroiteHautX;
		this.pointDroiteHautY = pointDroiteHautY;
		this.pointDroiteBasX = pointDroiteBasX;
		this.pointDroiteBasY = pointDroiteBasY;
		this.pointGaucheHautX = pointGaucheHautX;
		this.pointGaucheHautY = pointGaucheHautY;
		this.pointGaucheBasX = pointGaucheBasX;
		this.pointGaucheBasY = pointGaucheBasY;
		this.area = area;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPointDroiteHautX() {
		return pointDroiteHautX;
	}
	public void setPointDroiteHautX(int pointDroiteHautX) {
		this.pointDroiteHautX = pointDroiteHautX;
	}
	public int getPointDroiteHautY() {
		return pointDroiteHautY;
	}
	public void setPointDroiteHautY(int pointDroiteHautY) {
		this.pointDroiteHautY = pointDroiteHautY;
	}
	public int getPointDroiteBasX() {
		return pointDroiteBasX;
	}
	public void setPointDroiteBasX(int pointDroiteBasX) {
		this.pointDroiteBasX = pointDroiteBasX;
	}
	public int getPointDroiteBasY() {
		return pointDroiteBasY;
	}
	public void setPointDroiteBasY(int pointDroiteBasY) {
		this.pointDroiteBasY = pointDroiteBasY;
	}
	public int getPointGaucheHautX() {
		return pointGaucheHautX;
	}
	public void setPointGaucheHautX(int pointGaucheHautX) {
		this.pointGaucheHautX = pointGaucheHautX;
	}
	public int getPointGaucheHautY() {
		return pointGaucheHautY;
	}
	public void setPointGaucheHautY(int pointGaucheHautY) {
		this.pointGaucheHautY = pointGaucheHautY;
	}
	public int getPointGaucheBasX() {
		return pointGaucheBasX;
	}
	public void setPointGaucheBasX(int pointGaucheBasX) {
		this.pointGaucheBasX = pointGaucheBasX;
	}
	public int getPointGaucheBasY() {
		return pointGaucheBasY;
	}
	public void setPointGaucheBasY(int pointGaucheBasY) {
		this.pointGaucheBasY = pointGaucheBasY;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
    
    
    
}
