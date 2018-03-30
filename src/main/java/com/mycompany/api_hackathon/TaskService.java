package com.mycompany.api_hackathon;

import com.mycompany.DTO.List.Tasks;
import com.mycompany.DTO.Response;
import com.mycompany.DTO.Task;
import com.mycompany.Interface.TaskServiceInterface;
import com.mycompany.Model.Task_AccessManager;
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

@Path("/taskService")
public class TaskService implements TaskServiceInterface
{ 
    private static Map<Integer,Task> taskMap = new HashMap<Integer,Task>();
    Task_AccessManager accessManager = new Task_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Tasks tasks() 
    {
//		String tasks = null;
                taskMap = new HashMap<Integer,Task>();
                Tasks c = new Tasks();
		try
		{
                    taskMap = accessManager.getTasks();
                    ArrayList<Task> taskList = new ArrayList(taskMap.values());
                    
                    c.setTaskList(taskList);
                    
//                    Gson gson = new Gson();
//                    tasks = gson.toJson(taskList);
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
    public Task getTask(@PathParam("id") int id) 
    {
        return taskMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Task getDummyPerson(@PathParam("id") int id) 
    {
                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		Task p = new Task();
                
		p.setDescription("Dummy task");
                p.setDeadline(dateFormat.format(new Date()));
		p.setTid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addTask(Task p) 
    {
		Response response = new Response();
		if(taskMap.get(p.getTid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Task Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addTask(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(TaskService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		taskMap.put(p.getTid(), p);
		response.setStatus(true);
		response.setMessage("Task created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateTask(Task p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(taskMap.get(p.getTid()) != null)
                {
                    try 
                    {
                        accessManager.updateTask(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(TaskService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    taskMap.put(p.getTid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Task updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Task Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteTask(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(taskMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Task Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteTask(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(TaskService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		taskMap.remove(id);
		response.setStatus(true);
		response.setMessage("Task deleted successfully");
		return response;
    }
}