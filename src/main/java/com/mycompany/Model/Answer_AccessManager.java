package com.mycompany.Model;

import com.mycompany.DAO.Answer_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Answer;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Answer_AccessManager
{
	public Map<Integer,Answer> getAnswers() throws Exception
	{
		Map<Integer,Answer> answerMap = new HashMap<Integer,Answer>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Answer_Access access = new Answer_Access();
                
		answerMap = access.getAnswers(con);
                System.out.println("getall----AccessManager");
                
		return answerMap;
	}
        
        public void addAnswer(Answer ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Answer_Access access = new Answer_Access();
                
                access.addAnswer(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateAnswer(int AID, Answer ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Answer_Access access = new Answer_Access();
                
                access.updateAnswer(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteAnswer(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Answer_Access access = new Answer_Access();
                
                access.deleteAnswer(con, AID);
                System.out.println("delete----AccessManager");
        }
}