package com.example.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.VehicleCombustion;
import com.example.demo.service.CombustionService;


@Path("/combustion")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class CombustionController {
	
	private CombustionService combustionService;
	
	public CombustionController (CombustionService combustionService) {
		
		this.combustionService = combustionService;
	}

	/**
	 * GET http://localhost:8080/api/combustion
	 */
    @GET
    public List<VehicleCombustion> findAll(){
        return combustionService.findAll();
    }

    /**
     * GET
     * http://localhost:8080/api/combustion/1
     * http://localhost:8080/api/combustion/2
     * http://localhost:8080/api/combustion/3
     * 
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	VehicleCombustion combustion = combustionService.findOne(id);
        if (combustion == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(combustion).build();
    }
    /**
     * GET http://localhost:8080/api/combustion/blue
     * GET http://localhost:8080/api/combustion/red
     * GET http://localhost:8080/api/combustion/purple
     * GET http://localhost:8080/api/combustion/
     */
    
    @GET
    @Path("/color/{color}")
    public List<VehicleCombustion> findByColor(@PathParam("color") String color){
    	return combustionService.findByColor(color);
    }

    /**
     * GET http://localhost:8080/api/combustion/door/blue
     * GET http://localhost:8080/api/combustion/door/red
     * GET http://localhost:8080/api/combustion/door/purple
     * GET http://localhost:8080/api/combustion/door/other
     */
    
    @GET
    @Path("/numDoors/{numDoors}")
    public List<VehicleCombustion> findByNumDoors(@PathParam("numDoors") Integer numDoors){
    	return combustionService.findByNumDoors(numDoors);
    }
    /**
     * GET http://localhost:8080/api/combustion/name/blue
     * GET http://localhost:8080/api/combustion/name/red
     * GET http://localhost:8080/api/combustion/name/purple
     * GET http://localhost:8080/api/combustion/name/other
     */
    
    @GET
    @Path("/name/{name}")
    public List<VehicleCombustion> findByName(@PathParam("name") String name){
    	return combustionService.findByName(name);
    }
    /**
     * POST http://localhost:8080/api/combustion
     */
    @POST // CREAR NUEVO
    public Response create(VehicleCombustion combustion){
        if (combustion.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleCombustion result = combustionService.save(combustion);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/combustion
     */
    @PUT // ACTUALIZAR
    public Response update(VehicleCombustion combustion){
        if (combustion.getId() == null || combustion.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleCombustion result = combustionService.save(combustion);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/combustion/1
     * http://localhost:8080/api/combustion/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!combustionService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/combustion
     */
    @DELETE
    public Response deleteAll(){
    	combustionService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }

}
