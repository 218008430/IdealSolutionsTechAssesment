package EthanGeorge.JobListing.resources;

import EthanGeorge.JobListing.entity.Jobs;
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
@Path("/jobs")
public class JobResources {
    
    private JobService jobService;
    private String newJobId;
    
    @Autowired
    public JobResources(JobService jobService) {
        this.jobService = jobService;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Jobs> findAll() {
        return this.jobService.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getJob(@PathParam("id") int jobId) {

        Jobs job = this.jobService.findById(jobId);

        if (job != null) {
            return Response.ok(job, MediaType.APPLICATION_JSON).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addJob(@RequestBody Jobs job) throws URISyntaxException {
        int newjobId = this.jobService.save(job);
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        URI uri = new URI("/jobs/" + newJobId);
        return Response.created(uri).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateJob(@PathParam("id") int id, Jobs job) {
        job.setId(id);

        if(this.jobService.update(job)){
            return Response.ok().entity(job).build();
        }else{
            return Response.notModified().build();
        }
    }
    
   
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteJob(@PathParam("id") int jobId) {
        if (this.jobService.deleteById(jobId) == true) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}
