package com.mycompany.api_hackathon;

import com.mycompany.DTO.Response;
import com.mycompany.DTO.Status;
import com.mycompany.DTO.List.Statuses;
import com.mycompany.Interface.StatusServiceInterface;
import com.mycompany.Model.Status_AccessManager;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;

@Path("/statusService")
public class StatusService implements StatusServiceInterface
{ 
    private static Map<Integer,Status> statusMap = new HashMap<Integer,Status>();
    Status_AccessManager accessManager = new Status_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Statuses statuses() 
    {
//		String statuses = null;
                statusMap = new HashMap<Integer,Status>();
                Statuses c = new Statuses();
		try
		{
                    statusMap = accessManager.getStatuses();
                    ArrayList<Status> statusList = new ArrayList(statusMap.values());
                    
                    c.setStatusList(statusList);
                    
//                    Gson gson = new Gson();
//                    statuses = gson.toJson(statusList);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
		return c;
    }
    
    @Override
    @GET
    @Path("/{id}/get")
    @Produces("application/json")
    public Status getStatus(@PathParam("id") int id) 
    {
        return statusMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Status getDummyPerson(@PathParam("id") int id) 
    {
		Status p = new Status();
                
                p.setStatus("Dummy Status");
		p.setStatusId(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addStatus(Status p) 
    {
		Response response = new Response();
		if(statusMap.get(p.getStatusId()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Status Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addStatus(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(StatusService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		statusMap.put(p.getStatusId(), p);
		response.setStatus(true);
		response.setMessage("Status created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateStatus(Status p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(statusMap.get(p.getStatusId()) != null)
                {
                    try 
                    {
                        accessManager.updateStatus(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(StatusService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    statusMap.put(p.getStatusId(), p);		
                    response.setStatus(true);		
                    response.setMessage("Status updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Status Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteStatus(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(statusMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Status Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteStatus(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(StatusService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		statusMap.remove(id);
		response.setStatus(true);
		response.setMessage("Status deleted successfully");
		return response;
    }
}