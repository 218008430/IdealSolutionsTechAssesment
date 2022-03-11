/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.resources;

import EthanGeorge.JobListing.entity.Canidates;
import EthanGeorge.JobListing.entity.Jobs;
import EthanGeorge.JobListing.services.CanidateService;
import EthanGeorge.JobListing.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


/**
 *
 * @author Ethan
 */
@Path("/canidates")
public class CanidateResources {
    
      private CanidateService canidateService;
    private String newCanidateId;
    
    @Autowired
    public CanidateResources(CanidateService canidateService) {
        this.canidateService = canidateService;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Canidates> findAll() {
        return this.canidateService.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCanidate(@PathParam("id") int canidateId) {

        Canidates canidate = this.canidateService.findById(canidateId);

        if (canidate != null) {
            return Response.ok(canidate, MediaType.APPLICATION_JSON).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addCanidate(@RequestBody Canidates canidate) throws URISyntaxException {
        int newcanidateId = this.canidateService.save(canidate);
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        URI uri = new URI("/canidates/" + newCanidateId);
        return Response.created(uri).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateCanidate(@PathParam("id") int id, Canidates canidate) {
        canidate.setId(id);

        if(this.canidateService.update(canidate)){
            return Response.ok().entity(canidate).build();
        }else{
            return Response.notModified().build();
        }
    }
    
   
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCanidate(@PathParam("id") int canidateId) {
        if (this.canidateService.deleteById(canidateId) == true) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    
}
