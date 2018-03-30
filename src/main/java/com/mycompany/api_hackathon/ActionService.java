package com.mycompany.api_hackathon;

import com.mycompany.DTO.Response;
import com.mycompany.DTO.Action;
import com.mycompany.DTO.List.Actions;
import com.mycompany.Interface.ActionServiceInterface;
import com.mycompany.Model.Action_AccessManager;
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

@Path("/actionService")
public class ActionService implements ActionServiceInterface
{ 
    private static Map<Integer,Action> actionMap = new HashMap<Integer,Action>();
    Action_AccessManager accessManager = new Action_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Actions actions() 
    {
//		String actions = null;
                actionMap = new HashMap<Integer,Action>();
                Actions c = new Actions();
		try
		{
                    actionMap = accessManager.getActions();
                    ArrayList<Action> actionList = new ArrayList(actionMap.values());
                    
                    c.setActionList(actionList);
                    
//                    Gson gson = new Gson();
//                    actions = gson.toJson(actionList);
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
    public Action getAction(@PathParam("id") int id) 
    {
        return actionMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Action getDummyPerson(@PathParam("id") int id) 
    {
		Action p = new Action();
                
                p.setAction("Dummy Action");
		p.setActionId(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addAction(Action p) 
    {
		Response response = new Response();
		if(actionMap.get(p.getActionId()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Action Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addAction(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ActionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		actionMap.put(p.getActionId(), p);
		response.setStatus(true);
		response.setMessage("Action created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateAction(Action p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(actionMap.get(p.getActionId()) != null)
                {
                    try 
                    {
                        accessManager.updateAction(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ActionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    actionMap.put(p.getActionId(), p);		
                    response.setStatus(true);		
                    response.setMessage("Action updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Action Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteAction(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(actionMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Action Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteAction(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(ActionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		actionMap.remove(id);
		response.setStatus(true);
		response.setMessage("Action deleted successfully");
		return response;
    }
}