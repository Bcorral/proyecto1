package com.example.demo.domain.pieces;

public class VehicleHybridHydrogenTank {
	
	private Long id;
	private Double liters;
	
	public VehicleHybridHydrogenTank() {}

	public VehicleHybridHydrogenTank(Long id, Double liters) {
		this.id = id;
		this.liters = liters;
	}

	public Long getId() {
		return id;
	}

	public Double getLiters() {
		return liters;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLiters(Double liters) {
		this.liters = liters;
	}

	@Override
	public String toString() {
		return "VehicleHybridHydrogenTank [id=" + id + ", liters=" + liters + "]";
	}
	
	
	
}
