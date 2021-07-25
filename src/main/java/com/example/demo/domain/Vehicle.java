package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;


public abstract class Vehicle {
	
	// Atributos que tienen en comun todos los coches y que heredaran las clases hijas
	
	private Long id;
	private String name;
	private String color;
	private Integer numDoors;	
	private AirConditioning airConditioning;
	private Motor motor;

	
	// Constructores
	
	protected Vehicle() {}


	protected Vehicle(Long id, String name, String color, Integer numDoors, AirConditioning airConditioning,
			 Motor motor) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.numDoors = numDoors;
		this.airConditioning = airConditioning;
		this.motor = motor;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getColor() {
		return color;
	}


	public Integer getNumDoors() {
		return numDoors;
	}


	public AirConditioning getAirConditioning() {
		return airConditioning;
	}


	public Motor getMotor() {
		return motor;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setNumDoors(Integer numDoors) {
		this.numDoors = numDoors;
	}


	public void setAirConditioning(AirConditioning airConditioning) {
		this.airConditioning = airConditioning;
	}



	public void setMotor(Motor motor) {
		this.motor = motor;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", color=" + color + ", numDoors=" + numDoors
				+ ", airConditioning=" + airConditioning + ",  motor=" + motor + "]";
	}
	
	
	
	

}
