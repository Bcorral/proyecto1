package com.example.demo.domain.pieces;

public class VehicleElectricAutonomy {
	
	private Long id;
	private Battery battery;
	
	public VehicleElectricAutonomy() {}

	public VehicleElectricAutonomy(Long id, Battery battery) {
		this.id = id;
		this.battery = battery;
	}

	public Long getId() {
		return id;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "VehicleElectricAutonomy [id=" + id + ", battery=" + battery + "]";
	}



	
	
	

}
