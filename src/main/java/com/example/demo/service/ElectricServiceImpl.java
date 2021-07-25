package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.example.demo.domain.VehicleElectric;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleElectricAutonomy;

@Service
public class ElectricServiceImpl implements ElectricService {
	
	/**
	 * Emulates a database with java hashmap
	 */
	
	private static final Map<Long, VehicleElectric> vehicleElectrics = new HashMap<>();
	
	static {// hardcoded demo data
		
		//Battery battery1 = new Battery(1L, 0.0);
		VehicleElectric electric1 = new VehicleElectric(1L, "hyundai", "blue", 3,
				new AirConditioning(1L, true), 
				new Motor(1L, true), 
				new VehicleElectricAutonomy(1L,new Battery(1L, 0.0) ));
	
		//Battery battery2 = new Battery(2L, 1.0);
		VehicleElectric electric2 = new VehicleElectric(2L, "seat", "red", 3,
				new AirConditioning(2L, true), 
				new Motor(2L, true), 
				new VehicleElectricAutonomy(2L,new Battery(2L, 1.0) ));
		
		//Battery battery3 = new Battery(3L, 0.3);
		VehicleElectric electric3 = new VehicleElectric(3L, "hyundai", "purple", 3,
				new AirConditioning(3L, true), 
				new Motor(3L, true), 
				new VehicleElectricAutonomy(3L,new Battery(3L, 0.3 )));
		
		
		vehicleElectrics.put(1L, electric1);
		vehicleElectrics.put(2L, electric2);
		vehicleElectrics.put(3L, electric3);
		
	}

	@Override
	public Integer count() {
		return vehicleElectrics.keySet().size();
	}

	@Override
	public List<VehicleElectric> findAll() {
		return new ArrayList<>(vehicleElectrics.values());
	}

	@Override
	public VehicleElectric findOne(Long id) {
		return vehicleElectrics.get(id);
	}

	@Override
	public VehicleElectric save(VehicleElectric vehicleElectric) {
		// asignar un id
        if (vehicleElectric.getId() == null || vehicleElectric.getId() == 0L) // new vehicle electric
        	vehicleElectric.setId(getMaxVehicleElectricId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        vehicleElectrics.remove(vehicleElectric.getId()); // en caso de que ya exista lo quita para actualizarlo

        // save vehicle combustion in the map
        vehicleElectrics.put(vehicleElectric.getId(), vehicleElectric);
        return vehicleElectric;
	}

	/**
     * return the id bigger of the map vehicle electric
     * @return
     */
    private Long getMaxVehicleElectricId() {
    	if (vehicleElectrics.isEmpty())
			return 0L;

        return Collections.max(vehicleElectrics.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
	
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehicleElectrics.containsKey(id))
            return false;
		vehicleElectrics.remove(id);
        return true;
	}
	

	@Override
	public void deleteAll() {
		if (!vehicleElectrics.isEmpty())
			vehicleElectrics.clear();
		
	}

	@Override
	public List<VehicleElectric> findByColor(String color) {
		List<VehicleElectric> listColor = new ArrayList<>();
		for(VehicleElectric car : this.findAll()) {
			if (car.getColor().equals(color)){
				listColor.add(car);
			}
		}
		return  listColor;
	}

	@Override
	public List<VehicleElectric> findByName(String name) {
		List<VehicleElectric> listName = new ArrayList<>();
		for(VehicleElectric car : this.findAll()) {
			if (car.getName().equals(name)){
				listName.add(car);
			}
		}
		return  listName;
		
	}

	@Override
	public List<VehicleElectric> findByNumDoors(Integer numDoors) {
		List<VehicleElectric> listNumDoors = new ArrayList<>();
		for(VehicleElectric car : this.findAll()) {
			if (car.getNumDoors().equals(numDoors)){
				listNumDoors.add(car);
			}
		}
		return  listNumDoors;
	}
//	
	/**
	 * Emulates a database with java hashmap
	 */

}
