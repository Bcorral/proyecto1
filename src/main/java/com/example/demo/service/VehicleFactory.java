package com.example.demo.service;

import com.example.demo.domain.Vehicle;

public class VehicleFactory {
	
	private static final String ELECTRIC = "electric";
	private static final String COMBUSTION = "combustion";
	private static final String HYBRID = "hybrid";
	
	private VehicleFactory() {}

	public static Vehicle createByType(String type) {
		
		return switch (type) {
			case ELECTRIC -> VehicleFacade.createVehicleElectric();
			case COMBUSTION -> VehicleFacade.createVehicleCombustion();
			case HYBRID -> VehicleFacade.createVehicleHybrid();
			default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}

}
