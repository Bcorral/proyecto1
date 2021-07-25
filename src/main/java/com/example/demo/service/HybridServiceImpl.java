package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.VehicleHybrid;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.VehicleHybridHydrogenTank;

@Service
public class HybridServiceImpl implements HybridService{
	
	
	
	/**
	 * Emulates a database with java hashmap
	 */
	
	private static final Map<Long, VehicleHybrid> vehicleHybrids = new HashMap<>();
	
	static {// hardcoded demo data
	
		VehicleHybrid vehicleHybrid1 = new VehicleHybrid(1L,"toyota", "black", 3,
				new AirConditioning(1L, true),
				new Motor(1L, true), 
				new VehicleHybridHydrogenTank(1L, 20.0));
	
		VehicleHybrid vehicleHybrid2 = new VehicleHybrid(2L,"rolls", "yellow", 3,
				new AirConditioning(2L, true),
				new Motor(2L, true), 
				new VehicleHybridHydrogenTank(2L, 20.0));
		
		VehicleHybrid vehicleHybrid3 = new VehicleHybrid(3L,"toyota", "pink", 3,
				new AirConditioning(3L, true),
				new Motor(3L, true), 
				new VehicleHybridHydrogenTank(3L, 20.0));
	
		vehicleHybrids.put(1L, vehicleHybrid1);
		vehicleHybrids.put(2L, vehicleHybrid2);
		vehicleHybrids.put(3L, vehicleHybrid3);
	
	}
	@Override
	public Integer count() {
		return vehicleHybrids.keySet().size();
	}

	@Override
	public List<VehicleHybrid> findAll() {
		return new ArrayList<>(vehicleHybrids.values());
	}

	@Override
	public VehicleHybrid findOne(Long id) {
		return vehicleHybrids.get(id);
	}

	@Override
	public VehicleHybrid save(VehicleHybrid vehicleHybrid) {
		// asignar un id
        if (vehicleHybrid.getId() == null || vehicleHybrid.getId() == 0L) // new vehicle hybrid
        	vehicleHybrid.setId(getMaxVehicleHybridId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        vehicleHybrids.remove(vehicleHybrid.getId()); // en caso de que ya exista lo quita para actualizarlo

        // save vehicle combustion in the map
        vehicleHybrids.put(vehicleHybrid.getId(), vehicleHybrid);
        return vehicleHybrid;
	}

	/**
     * return the id bigger of the map vehicle combustion
     * @return
     */
    private Long getMaxVehicleHybridId() {
    	if (vehicleHybrids.isEmpty())
			return 0L;

        return Collections.max(vehicleHybrids.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
	
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehicleHybrids.containsKey(id))
            return false;
		vehicleHybrids.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!vehicleHybrids.isEmpty())
			vehicleHybrids.clear();
		
	}

	@Override
	public List<VehicleHybrid> findByColor(String color) {
		List<VehicleHybrid> listColor = new ArrayList<>();
		for(VehicleHybrid car : this.findAll()) {
			if (car.getColor().equals(color)){
				listColor.add(car);
			}
		}
		return  listColor;
	}

	@Override
	public List<VehicleHybrid> findByName(String name) {
		List<VehicleHybrid> listName = new ArrayList<>();
		for(VehicleHybrid car : this.findAll()) {
			if (car.getName().equals(name)){
				listName.add(car);
			}
		}
		return  listName;
		
	}

	@Override
	public List<VehicleHybrid> findByNumDoors(Integer numDoors) {
		List<VehicleHybrid> listNumDoors = new ArrayList<>();
		for(VehicleHybrid car : this.findAll()) {
			if (car.getNumDoors().equals(numDoors)){
				listNumDoors.add(car);
			}
		}
		return  listNumDoors;
	}
	
	
	/**
	 * Emulates a database with java hashmap
	 */
	
	

}
