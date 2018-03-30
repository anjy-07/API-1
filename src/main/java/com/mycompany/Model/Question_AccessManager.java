package com.mycompany.Model;

import com.mycompany.DAO.Database;
import com.mycompany.DAO.Question_Access;
import com.mycompany.DTO.Question;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Question_AccessManager
{
	public Map<Integer,Question> getQuestions() throws Exception
	{
		Map<Integer,Question> questionMap = new HashMap<Integer,Question>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Question_Access access = new Question_Access();
                
		questionMap = access.getQuestions(con);
                System.out.println("getall----AccessManager");
                
		return questionMap;
	}
        
        public void addQuestion(Question q) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Question_Access access = new Question_Access();
                
                access.addQuestion(con, q);
                System.out.println("add----AccessManager");
        }        
        
        public void updateQuestion(int QID, Question q) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Question_Access access = new Question_Access();
                
                access.updateQuestion(con, QID, q);
                System.out.println("update----AccessManager");
        }
        
        public void deleteQuestion(int QID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Question_Access access = new Question_Access();
                
                access.deleteQuestion(con, QID);
                System.out.println("delete----AccessManager");
        }
}