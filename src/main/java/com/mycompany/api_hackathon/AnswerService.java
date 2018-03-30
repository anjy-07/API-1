package com.mycompany.api_hackathon;

import com.mycompany.DTO.Answer;
import com.mycompany.DTO.List.Answers;
import com.mycompany.DTO.Question;
import com.mycompany.DTO.Response;
import com.mycompany.DTO.Visit;
import com.mycompany.Interface.AnswerServiceInterface;
import com.mycompany.Model.Answer_AccessManager;
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

@Path("/answerService")
public class AnswerService implements AnswerServiceInterface
{ 
    private static Map<Integer,Answer> answerMap = new HashMap<Integer,Answer>();
    Answer_AccessManager accessManager = new Answer_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Answers answers() 
    {
//		String answers = null;
                answerMap = new HashMap<Integer,Answer>();
                Answers c = new Answers();
		try
		{
                    answerMap = accessManager.getAnswers();
                    ArrayList<Answer> answerList = new ArrayList(answerMap.values());
                    
                    c.setAnswerList(answerList);
                    
//                    Gson gson = new Gson();
//                    answers = gson.toJson(answerList);
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
    public Answer getAnswer(@PathParam("id") int id) 
    {
        return answerMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Answer getDummyPerson(@PathParam("id") int id) 
    {
		Answer p = new Answer();
                Question q = new Question();
                Visit v = new Visit();
                
                p.setAnswer("Dummy Answer");
                p.setQid(q);
                p.setVid(v);
		p.setAnsId(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addAnswer(Answer p) 
    {
		Response response = new Response();
		if(answerMap.get(p.getAnsId()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Answer Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addAnswer(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AnswerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		answerMap.put(p.getAnsId(), p);
		response.setStatus(true);
		response.setMessage("Answer created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateAnswer(Answer p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(answerMap.get(p.getAnsId()) != null)
                {
                    try 
                    {
                        accessManager.updateAnswer(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AnswerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    answerMap.put(p.getAnsId(), p);		
                    response.setStatus(true);		
                    response.setMessage("Answer updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Answer Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteAnswer(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(answerMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Answer Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteAnswer(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AnswerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		answerMap.remove(id);
		response.setStatus(true);
		response.setMessage("Answer deleted successfully");
		return response;
    }
}