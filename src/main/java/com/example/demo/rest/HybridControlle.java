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


import com.example.demo.domain.VehicleHybrid;
import com.example.demo.service.HybridService;


@Path("/hybrid")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class HybridControlle {

	private HybridService hybridService;	

	public HybridControlle(HybridService hybridService) {
		this.hybridService = hybridService;
	}

	/**
	 * GET http://localhost:8080/api/hybrid
	 */
    @GET
    public List<VehicleHybrid> findAll(){
        return hybridService.findAll();
    }

    /**
     * GET
     * http://localhost:8080/api/hybrid/1
     * http://localhost:8080/api/hybrid/2
     * http://localhost:8080/api/hybrid/3
     * 
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	VehicleHybrid hybrid = hybridService.findOne(id);
        if (hybrid == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(hybrid).build();
    }
    /**
     * GET http://localhost:8080/api/hybrid/blue
     * GET http://localhost:8080/api/hybrid/red
     * GET http://localhost:8080/api/hybrid/purple
     * GET http://localhost:8080/api/hybrid/
     */
    
    @GET
    @Path("/color/{color}")
    public List<VehicleHybrid> findByColor(@PathParam("color") String color){
    	return hybridService.findByColor(color);
    }

    /**
     * GET http://localhost:8080/api/hybrid/door/blue
     * GET http://localhost:8080/api/hybrid/door/red
     * GET http://localhost:8080/api/hybrid/door/purple
     * GET http://localhost:8080/api/hybrid/door/other
     */
    
    @GET
    @Path("/numDoors/{numDoors}")
    public List<VehicleHybrid> findByNumDoors(@PathParam("numDoors") Integer numDoors){
    	return hybridService.findByNumDoors(numDoors);
    }
    /**
     * GET http://localhost:8080/api/hybrid/name/blue
     * GET http://localhost:8080/api/hybrid/name/red
     * GET http://localhost:8080/api/hybrid/name/purple
     * GET http://localhost:8080/api/hybrid/name/other
     */
    
    @GET
    @Path("/name/{name}")
    public List<VehicleHybrid> findByName(@PathParam("name") String name){
    	return hybridService.findByName(name);
    }
    /**
     * POST http://localhost:8080/api/hybrid
     */
    @POST // CREAR NUEVO
    public Response create(VehicleHybrid hybrid){
        if (hybrid.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleHybrid result = hybridService.save(hybrid);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/hybrid
     */
    @PUT // ACTUALIZAR
    public Response update(VehicleHybrid hybrid){
        if (hybrid.getId() == null || hybrid.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleHybrid result = hybridService.save(hybrid);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/hybrid/1
     * http://localhost:8080/api/hybrid/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!hybridService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/hybrid
     */
    @DELETE
    public Response deleteAll(){
    	hybridService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
