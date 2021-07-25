package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleElectricAutonomy;

public class VehicleElectric extends Vehicle{
	
	// Atributos
	
	private VehicleElectricAutonomy vehicleElectricAutonomy;


	
	// Constructores
	
	
	public VehicleElectric() {}

	public VehicleElectric(Long id, String name, String color, Integer numDoors, AirConditioning airConditioning,
			Motor motor, VehicleElectricAutonomy vehicleElectricAutonomy) {
		super(id, name, color, numDoors, airConditioning, motor);
		this.vehicleElectricAutonomy = vehicleElectricAutonomy;
	}
	// Getters y Setters

	public VehicleElectricAutonomy getVehicleElectricAutonomy() {
		return vehicleElectricAutonomy;
	}

	public void setVehicleElectricAutonomy(VehicleElectricAutonomy vehicleElectricAutonomy) {
		this.vehicleElectricAutonomy = vehicleElectricAutonomy;
	}

	@Override
	public String toString() {
		return "VehicleElectric [vehicleElectricAutonomy=" + vehicleElectricAutonomy + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getColor()=" + getColor() + ", getNumDoors()=" + getNumDoors()
				+ ", getAirConditioning()=" + getAirConditioning() + ", getMotor()=" + getMotor() + "]";
	}
	
	



	




	
}
