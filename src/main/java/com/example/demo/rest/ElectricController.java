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

import com.example.demo.domain.VehicleElectric;
import com.example.demo.service.ElectricService;



@Path("/electric")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class ElectricController {
	
	private ElectricService electricService;
	
	public ElectricController(ElectricService electricService) {

		this.electricService = electricService;
	}

	/**
	 * GET http://localhost:8080/api/electric
	 */
    @GET
    public List<VehicleElectric> findAll(){
        return electricService.findAll();
    }

    /**
     * GET
     * http://localhost:8080/api/electric/1
     * http://localhost:8080/api/electric/2
     * http://localhost:8080/api/electric/3
     * 
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	VehicleElectric electric = electricService.findOne(id);
        if (electric == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(electric).build();
    }
    
    /**
     * GET http://localhost:8080/api/electric/blue
     * GET http://localhost:8080/api/electric/red
     * GET http://localhost:8080/api/electric/purple
     * GET http://localhost:8080/api/electric/
     */
 
    @GET
    @Path("/color/{color}")
    public List<VehicleElectric> findByColor(@PathParam("color") String color){
    	return electricService.findByColor(color);
    	
    }

    /**
     * GET http://localhost:8080/api/electric/door/blue
     * GET http://localhost:8080/api/electric/door/red
     * GET http://localhost:8080/api/electric/door/purple
     * GET http://localhost:8080/api/electric/door/other
     */
    
    @GET
    @Path("/numDoors/{numDoors}")
    public List<VehicleElectric> findByNumDoors(@PathParam("numDoors") Integer numDoors){
    	return electricService.findByNumDoors(numDoors);
    	
    }
    /**
     * GET http://localhost:8080/api/electric/name/blue
     * GET http://localhost:8080/api/electric/name/red
     * GET http://localhost:8080/api/electric/name/purple
     * GET http://localhost:8080/api/electric/name/other
     */
    
    @GET
    @Path("/name/{name}")
    public List<VehicleElectric> findByName(@PathParam("name") String name){
    	return electricService.findByName(name);
    }
    
    /**
     * POST http://localhost:8080/api/electric
     */
    @POST // CREAR NUEVO
    public Response create(VehicleElectric electric){
        if (electric.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleElectric result = electricService.save(electric);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/electric
     */
    @PUT // ACTUALIZAR
    public Response update(VehicleElectric electric){
        if (electric.getId() == null || electric.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        VehicleElectric result = electricService.save(electric);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/electric/1
     * http://localhost:8080/api/electric/2
     */
    @DELETE
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!electricService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/electric
     */
    @DELETE
    public Response deleteAll(){
    	electricService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	

}
