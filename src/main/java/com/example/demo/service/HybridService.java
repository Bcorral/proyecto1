package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.VehicleHybrid;




public interface HybridService {
	
	Integer count();

    List<VehicleHybrid> findAll();

    VehicleHybrid findOne(Long id);
    
    // Filtros
    List<VehicleHybrid> findByColor(String color);
    List<VehicleHybrid> findByName(String name);
    List<VehicleHybrid> findByNumDoors(Integer numDoors);
    
    VehicleHybrid save(VehicleHybrid vehicleHybrid);

    boolean delete(Long id);

    void deleteAll();

}
