package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleHybridHydrogenTank;

public class VehicleHybrid extends Vehicle {
    //Atributos
	private VehicleHybridHydrogenTank vehicleHybridHydrogenTank;

	// Constructores
	
	public VehicleHybrid() {}

	public VehicleHybrid(Long id, String name, String color, Integer numDoors, AirConditioning airConditioning,
			Motor motor, VehicleHybridHydrogenTank vehicleHybridHydrogenTank) {
		super(id, name, color, numDoors, airConditioning, motor);
		this.vehicleHybridHydrogenTank = vehicleHybridHydrogenTank;
	}

	// Getters y Setters 
	
	public VehicleHybridHydrogenTank getVehicleHybridHydrogenTank() {
		return vehicleHybridHydrogenTank;
	}

	public void setVehicleHybridHydrogenTank(VehicleHybridHydrogenTank vehicleHybridHydrogenTank) {
		this.vehicleHybridHydrogenTank = vehicleHybridHydrogenTank;
	}

	// ToString heredando de la clase Vehicle 
	@Override
	public String toString() {
		return "VehicleHybrid [vehicleHybridHydrogenTank=" + vehicleHybridHydrogenTank + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getColor()=" + getColor() + ", getNumDoors()=" + getNumDoors()
				+ ", getAirConditioning()=" + getAirConditioning() + ", getMotor()=" + getMotor() + "]";
	}
	

	
	
	
	

	
	
	
	
}
