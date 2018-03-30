package com.mycompany.api_hackathon;

import com.mycompany.DTO.Visit;
import com.mycompany.DTO.List.Visits;
import com.mycompany.DTO.Question;
import com.mycompany.DTO.Response;
import com.mycompany.DTO.Visit;
import com.mycompany.Interface.VisitServiceInterface;
import com.mycompany.Model.Visit_AccessManager;
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

@Path("/visitService")
public class VisitService implements VisitServiceInterface
{ 
    private static Map<Integer,Visit> visitMap = new HashMap<Integer,Visit>();
    Visit_AccessManager accessManager = new Visit_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Visits visits() 
    {
//		String visits = null;
                visitMap = new HashMap<Integer,Visit>();
                Visits c = new Visits();
		try
		{
                    visitMap = accessManager.getVisits();
                    ArrayList<Visit> visitList = new ArrayList(visitMap.values());
                    
                    c.setVisitList(visitList);
                    
//                    Gson gson = new Gson();
//                    visits = gson.toJson(visitList);
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
    public Visit getVisit(@PathParam("id") int id) 
    {
        return visitMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Visit getDummyPerson(@PathParam("id") int id) 
    {
		Visit p = new Visit();
                
                p.setRemarkOfficer("Dummy Visit");
		p.setVid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addVisit(Visit p) 
    {
		Response response = new Response();
		if(visitMap.get(p.getVid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Visit Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addVisit(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(VisitService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		visitMap.put(p.getVid(), p);
		response.setStatus(true);
		response.setMessage("Visit created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateVisit(Visit p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(visitMap.get(p.getVid()) != null)
                {
                    try 
                    {
                        accessManager.updateVisit(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(VisitService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    visitMap.put(p.getVid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Visit updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Visit Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteVisit(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(visitMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Visit Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteVisit(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(VisitService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		visitMap.remove(id);
		response.setStatus(true);
		response.setMessage("Visit deleted successfully");
		return response;
    }
}