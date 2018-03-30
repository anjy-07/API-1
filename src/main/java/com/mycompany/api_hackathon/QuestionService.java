package com.mycompany.api_hackathon;

import com.mycompany.DTO.List.Questions;
import com.mycompany.DTO.Programme;
import com.mycompany.DTO.Question;
import com.mycompany.DTO.Response;
import com.mycompany.Interface.QuestionServiceInterface;
import com.mycompany.Model.Question_AccessManager;
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

@Path("/questionService")
public class QuestionService implements QuestionServiceInterface
{ 
    private static Map<Integer,Question> questionMap = new HashMap<Integer,Question>();
    Question_AccessManager accessManager = new Question_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Questions questions() 
    {
//		String questions = null;
                questionMap = new HashMap<Integer,Question>();
                Questions c = new Questions();
		try
		{
                    questionMap = accessManager.getQuestions();
                    ArrayList<Question> questionList = new ArrayList(questionMap.values());
                    
                    c.setQuestionList(questionList);
                    
//                    Gson gson = new Gson();
//                    questions = gson.toJson(questionList);
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
		if(questionMap.get(id) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Question Already Exists");
                    return response;
		}
                
		response.setStatus(true);
		response.setMessage("Question Does Not Exist");
		return response;
    }
    
    @Override
    @GET
    @Path("/{id}/get")
    @Produces("application/json")
    public Question getQuestion(@PathParam("id") int id) 
    {
        return questionMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Question getDummyPerson(@PathParam("id") int id) 
    {
		Question p = new Question();
                Programme pid = new Programme();
                
		p.setQuestion("Dummy Question");
		p.setDescription("Dummy");
                p.setFormat("Dummy Format");
                p.setPid(pid);
                p.setVisitType("Dummy Visit");
		p.setQid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addQuestion(Question p) 
    {
		Response response = new Response();
		if(questionMap.get(p.getQid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Question Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addQuestion(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		questionMap.put(p.getQid(), p);
		response.setStatus(true);
		response.setMessage("Question created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateQuestion(Question p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(questionMap.get(p.getQid()) != null)
                {
                    try 
                    {
                        accessManager.updateQuestion(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    questionMap.put(p.getQid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Question updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Question Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteQuestion(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(questionMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Question Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteQuestion(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		questionMap.remove(id);
		response.setStatus(true);
		response.setMessage("Question deleted successfully");
		return response;
    }
}