package com.mycompany.api_hackathon;

import com.mycompany.DTO.List.Programmes;
import com.mycompany.DTO.Programme;
import com.mycompany.DTO.Response;
import com.mycompany.Interface.ProgrammeServiceInterface;
import com.mycompany.Model.Programme_AccessManager;
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

@Path("/programmeService")
public class ProgrammeService implements ProgrammeServiceInterface
{ 
    private static Map<Integer,Programme> programmeMap = new HashMap<Integer,Programme>();
    Programme_AccessManager accessManager = new Programme_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Programmes programmes() 
    {
//		String programmes = null;
                programmeMap = new HashMap<Integer,Programme>();
                Programmes c = new Programmes();
		try
		{
                    programmeMap = accessManager.getProgrammes();
                    ArrayList<Programme> programmeList = new ArrayList(programmeMap.values());
                    
                    c.setProgrammeList(programmeList);
                    
//                    Gson gson = new Gson();
//                    programmes = gson.toJson(programmeList);
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
    public Programme getProgramme(@PathParam("id") int id) 
    {
        return programmeMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Programme getDummyPerson(@PathParam("id") int id) 
    {
                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Programme p = new Programme();
                
		p.setName("Dummy Programme");
		p.setLaunchdate(dateFormat.format(new Date()));
                p.setDescription("Dummy");
		p.setPid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addProgramme(Programme p) 
    {
		Response response = new Response();
		if(programmeMap.get(p.getPid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Programme Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addProgramme(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ProgrammeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		programmeMap.put(p.getPid(), p);
		response.setStatus(true);
		response.setMessage("Programme created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateProgramme(Programme p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(programmeMap.get(p.getPid()) != null)
                {
                    try 
                    {
                        accessManager.updateProgramme(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ProgrammeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    programmeMap.put(p.getPid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Programme updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Programme Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteProgramme(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(programmeMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Programme Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteProgramme(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ProgrammeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		programmeMap.remove(id);
		response.setStatus(true);
		response.setMessage("Programme deleted successfully");
		return response;
    }
}