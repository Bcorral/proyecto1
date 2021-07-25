package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleCombustionFuel;

public class VehicleCombustion extends Vehicle {
	//Atributos
	
	private VehicleCombustionFuel vehicleCombustionFuel;
	
	// Constructores

	public VehicleCombustion() {}

	public VehicleCombustion(Long id, String name, String color, Integer numDoors, AirConditioning airConditioning,
			 Motor motor, VehicleCombustionFuel vehicleCombustionFuel) {
		super(id, name, color, numDoors, airConditioning, motor);
		this.vehicleCombustionFuel = vehicleCombustionFuel;		
	}
    // Getters Y Setters
	public VehicleCombustionFuel getVehicleCombustionFuel() {
		return vehicleCombustionFuel;
	}

	public void setVehicleCombustionFuel(VehicleCombustionFuel vehicleCombustionFuel) {
		this.vehicleCombustionFuel = vehicleCombustionFuel;
	}

	@Override
	public String toString() {
		return "VehicleCombustion [vehicleCombustionFuel=" + vehicleCombustionFuel + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getColor()=" + getColor() + ", getNumDoors()=" + getNumDoors()
				+ ", getAirConditioning()=" + getAirConditioning() + ", getMotor()="
				+ getMotor() + "]";
	}

	
	
	
	
	

}
