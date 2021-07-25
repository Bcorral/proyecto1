package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.example.demo.domain.VehicleCombustion;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleCombustionFuel;

@Service
public class CombustionServiceImpl implements CombustionService{
	
	
	/**
	 * Emulates a database with java hashmap
	 */
	
	private static final Map<Long, VehicleCombustion> vehicleCombustions = new HashMap<>();
	
	static {// hardcoded demo data
		
		VehicleCombustion combustion1 = new VehicleCombustion(1L,"toyota","white", 3,
				new AirConditioning(1L, true),
				new Motor(1L, true),
				new VehicleCombustionFuel(1L, "Diesel"));
		
				
		VehicleCombustion combustion2 = new VehicleCombustion(2L,"audi","grey", 5,
				new AirConditioning(2L, true),
				new Motor(2L, true),
				new VehicleCombustionFuel(2L, "gas"));
		
		VehicleCombustion combustion3 = new VehicleCombustion(3L,"toyota","green", 3,
				new AirConditioning(3L, true),
				new Motor(3L, true),
				new VehicleCombustionFuel(3L, "Diesel"));
		
		vehicleCombustions.put(1L, combustion1);
		vehicleCombustions.put(2L, combustion2);
		vehicleCombustions.put(3L, combustion3);
		
	}

	@Override
	public Integer count() {
		return vehicleCombustions.keySet().size();
	}

	@Override
	public List<VehicleCombustion> findAll() {
		return new ArrayList<>(vehicleCombustions.values());
	}

	@Override
	public VehicleCombustion findOne(Long id) {
		return vehicleCombustions.get(id);
	}

	@Override
	public VehicleCombustion save(VehicleCombustion vehicleCombustion) {
		// asignar un id
        if (vehicleCombustion.getId() == null || vehicleCombustion.getId() == 0L) // new vehicle combustion
        	vehicleCombustion.setId(getMaxVehicleCombustionId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        vehicleCombustions.remove(vehicleCombustion.getId()); // en caso de que ya exista lo quita para actualizarlo

        // save vehicle combustion in the map
        vehicleCombustions.put(vehicleCombustion.getId(), vehicleCombustion);
        return vehicleCombustion;
	}

	
	/**
     * return the id bigger of the map vehicle combustion
     * @return
     */
    private Long getMaxVehicleCombustionId() {
    	if (vehicleCombustions.isEmpty())
			return 0L;

        return Collections.max(vehicleCombustions.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehicleCombustions.containsKey(id))
            return false;
		vehicleCombustions.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!vehicleCombustions.isEmpty())
			vehicleCombustions.clear();
		
	}

	@Override
	public List<VehicleCombustion> findByColor(String color) {
		List<VehicleCombustion> listColor = new ArrayList<>();
		for(VehicleCombustion car : this.findAll()) {
			if (car.getColor().equals(color)){
				listColor.add(car);
			}
		}
		return  listColor;
	}

	@Override
	public List<VehicleCombustion> findByName(String name) {
		List<VehicleCombustion> listName = new ArrayList<>();
		for(VehicleCombustion car : this.findAll()) {
			if (car.getName().equals(name)){
				listName.add(car);
			}
		}
		return  listName;
	}

	@Override
	public List<VehicleCombustion> findByNumDoors(Integer numDoors) {
		List<VehicleCombustion> listNumDoors = new ArrayList<>();
		for(VehicleCombustion car : this.findAll()) {
			if (car.getNumDoors().equals(numDoors)){
				listNumDoors.add(car);
			}
		}
		return  listNumDoors;
	}
	}




