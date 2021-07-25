package com.example.demo.domain.pieces;

public class VehicleCombustionFuel {
	private Long id;
	private String fuel;
	
	public VehicleCombustionFuel() {}

	public VehicleCombustionFuel(Long id, String fuel) {
		this.id = id;
		this.fuel = fuel;
	}

	public Long getId() {
		return id;
	}

	public String getFuel() {
		return fuel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	@Override
	public String toString() {
		return "VehicleCombustionFuel [id=" + id + ", fuel=" + fuel + "]";
	}

	
	
	
	
	
	

}
