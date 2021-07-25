package com.example.demo.service;

import java.util.List;


import com.example.demo.domain.VehicleElectric;

public interface ElectricService {
	
	Integer count();

    List<VehicleElectric> findAll();

    VehicleElectric findOne(Long id);
    
    // Filtros
    List<VehicleElectric> findByColor(String color);
    List<VehicleElectric> findByName(String name);
    List<VehicleElectric> findByNumDoors(Integer numDoors);
    
    VehicleElectric save(VehicleElectric vehicleElectric);

    boolean delete(Long id);

    void deleteAll();

}
