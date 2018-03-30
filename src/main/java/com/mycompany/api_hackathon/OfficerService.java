package com.mycompany.api_hackathon;

import com.mycompany.DTO.List.Officers;
import com.mycompany.DTO.Officer;
import com.mycompany.DTO.Response;
import com.mycompany.Interface.OfficerServiceInterface;
import com.mycompany.Model.Officer_AccessManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

@Path("/officerService")
public class OfficerService implements OfficerServiceInterface
{ 
    private static Map<Integer,Officer> officerMap = new HashMap<Integer,Officer>();
    Officer_AccessManager accessManager = new Officer_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Officers officers() 
    {
//		String officers = null;
                officerMap = new HashMap<Integer,Officer>();
                Officers c = new Officers();
		try
		{
                    officerMap = accessManager.getOfficers();
                    ArrayList<Officer> officerList = new ArrayList(officerMap.values());
                    
                    c.setOfficerList(officerList);
                    
//                    Gson gson = new Gson();
//                    officers = gson.toJson(officerList);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
		return c;
    }
    
    @GET
    @Path("/{id}/check")
    @Produces("application/json")
    public Response checkQuestion(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(officerMap.get(id) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Officer Already Exists");
                    return response;
		}
                
		response.setStatus(true);
		response.setMessage("Officer Does Not Exist");
		return response;
    }
    
    @Override
    @GET
    @Path("/{id}/get")
    @Produces("application/json")
    public Officer getOfficer(@PathParam("id") int id) 
    {
        return officerMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Officer getDummyPerson(@PathParam("id") int id) 
    {
                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		Officer p = new Officer();
                
		p.setName("Dummy Officer");
                p.setDoj(dateFormat.format(new Date()));
                p.setRtd(dateFormat.format(new Date()));
		p.setOid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addOfficer(Officer p) 
    {
		Response response = new Response();
		if(officerMap.get(p.getOid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Officer Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addOfficer(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		officerMap.put(p.getOid(), p);
		response.setStatus(true);
		response.setMessage("Officer created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateOfficer(Officer p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(officerMap.get(p.getOid()) != null)
                {
                    try 
                    {
                        accessManager.updateOfficer(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    officerMap.put(p.getOid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Officer updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Officer Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteOfficer(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(officerMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Officer Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteOfficer(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		officerMap.remove(id);
		response.setStatus(true);
		response.setMessage("Officer deleted successfully");
		return response;
    }
}