package com.mycompany.api_hackathon;

import com.mycompany.DTO.List.Offices;
import com.mycompany.DTO.Office;
import com.mycompany.DTO.Response;
import com.mycompany.Interface.OfficeServiceInterface;
import com.mycompany.Model.Office_AccessManager;
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

@Path("/officeService")
public class OfficeService implements OfficeServiceInterface
{ 
    private static Map<Integer,Office> officeMap = new HashMap<Integer,Office>();
    Office_AccessManager accessManager = new Office_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Offices offices() 
    {
//		String offices = null;
                officeMap = new HashMap<Integer,Office>();
                Offices c = new Offices();
		try
		{
                    officeMap = accessManager.getOffices();
                    ArrayList<Office> officeList = new ArrayList(officeMap.values());
                    
                    c.setOfficeList(officeList);
                    
//                    Gson gson = new Gson();
//                    offices = gson.toJson(officeList);
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
		if(officeMap.get(id) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Office Already Exists");
                    return response;
		}
                
		response.setStatus(true);
		response.setMessage("Office Does Not Exist");
		return response;
    }
    
    @Override
    @GET
    @Path("/{id}/get")
    @Produces("application/json")
    public Office getOffice(@PathParam("id") int id) 
    {
        return officeMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Office getDummyPerson(@PathParam("id") int id) 
    {
                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		Office p = new Office();
                
		p.setAddress("Dummy Office");
		p.setOfficeId(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addOffice(Office p) 
    {
		Response response = new Response();
		if(officeMap.get(p.getOfficeId()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Office Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addOffice(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		officeMap.put(p.getOfficeId(), p);
		response.setStatus(true);
		response.setMessage("Office created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateOffice(Office p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(officeMap.get(p.getOfficeId()) != null)
                {
                    try 
                    {
                        accessManager.updateOffice(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    officeMap.put(p.getOfficeId(), p);		
                    response.setStatus(true);		
                    response.setMessage("Office updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Office Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteOffice(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(officeMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Office Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteOffice(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(OfficeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		officeMap.remove(id);
		response.setStatus(true);
		response.setMessage("Office deleted successfully");
		return response;
    }
}