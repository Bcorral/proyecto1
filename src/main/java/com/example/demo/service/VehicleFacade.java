package com.example.demo.service;

import com.example.demo.domain.Vehicle;
import com.example.demo.domain.VehicleCombustion;
import com.example.demo.domain.VehicleElectric;
import com.example.demo.domain.VehicleHybrid;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleCombustionFuel;
import com.example.demo.domain.pieces.VehicleElectricAutonomy;
import com.example.demo.domain.pieces.VehicleHybridHydrogenTank;

public class VehicleFacade {
	
	private VehicleFacade() {}	
	
	public static Vehicle createVehicleCombustion() {
		// vehicle pieces
		AirConditioning airConditioning = new AirConditioning(1L, true);
		Motor motor = new Motor(1L, true);
		
		// Vehicle Combustion exclusive pieces
		
		VehicleCombustionFuel vehicleCombustionFuel = new VehicleCombustionFuel(1L, "gas");
		
		VehicleCombustion vehicleCombustion = new VehicleCombustion(1L,"Audi","black", 3, airConditioning, motor, vehicleCombustionFuel);
		vehicleCombustion.getAirConditioning().start();
		vehicleCombustion.getMotor().start();
		return vehicleCombustion;
	}
	
	public static Vehicle createVehicleElectric() {
		
		// vehicle pieces
				AirConditioning airConditioning = new AirConditioning(1L, true);
				Motor motor = new Motor(1L, true);
				
				// Vehicle electric exclusive pieces
				Battery battery = new Battery(1L, 0.0);
				VehicleElectricAutonomy vehicleElectricAutonomy = new VehicleElectricAutonomy(1L, battery);
				VehicleElectric vehicleElectric = new VehicleElectric(1L,"toyota","blue", 3, airConditioning, motor, vehicleElectricAutonomy);
				vehicleElectric.getAirConditioning().start();
				vehicleElectric.getMotor().start();
				return vehicleElectric;
	}
	
	public static Vehicle createVehicleHybrid() {
		
		// vehicle pieces
				AirConditioning airConditioning = new AirConditioning(1L, true);
				Motor motor = new Motor(1L, true);
				
				// Vehicle electric exclusive pieces
				
				VehicleHybridHydrogenTank vehicleHybridHydrogenTank = new VehicleHybridHydrogenTank(1L, 5.4);
				VehicleHybrid vehicleHybrid = new VehicleHybrid(1L, "ford","red", 5, airConditioning, motor, vehicleHybridHydrogenTank);
				vehicleHybrid.getAirConditioning().start();
				vehicleHybrid.getMotor().start();
				return vehicleHybrid;
	}

}
