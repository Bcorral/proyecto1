package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.VehicleCombustion;

public interface CombustionService {
	
	Integer count();

    List<VehicleCombustion> findAll();

    VehicleCombustion findOne(Long id);
    
    // Filtros
    List<VehicleCombustion> findByColor(String color);
    List<VehicleCombustion> findByName(String name);
    List<VehicleCombustion> findByNumDoors(Integer numDoors);
    
    VehicleCombustion save(VehicleCombustion vehicleCombustion);

    boolean delete(Long id);

    void deleteAll();

}
