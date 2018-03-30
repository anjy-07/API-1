package com.mycompany.DAO;

import com.mycompany.DTO.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Answer_Access
{
	public Map<Integer,Answer> getAnswers(Connection con) throws SQLException
	{
		Map<Integer,Answer> answerMap = new HashMap<Integer,Answer>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ANSWER");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Answer answerObj = new Answer();
                                Question_Access qa = new Question_Access();
                                Visit_Access va = new Visit_Access();
                                
				answerObj.setAnsId(rs.getInt("ANS_ID"));
				answerObj.setAnswer(rs.getString("ANSWER"));
                                answerObj.setQid(qa.getQuestion(con, rs.getInt("QID")));
                                answerObj.setVid(va.getVisit(con, rs.getInt("VID")));
                                
				answerMap.put(rs.getInt("ANS_ID"), answerObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return answerMap;		
	}
        
	public Answer getAnswer(Connection con, int ANS_ID) throws SQLException
	{
                Answer answerObj = new Answer();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ANSWER where ANS_ID = "+ANS_ID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
                        {                            
                                Question_Access qa = new Question_Access();
                                Visit_Access va = new Visit_Access();
                                
				answerObj.setAnsId(rs.getInt("ANS_ID"));
				answerObj.setAnswer(rs.getString("ANSWER"));
                                answerObj.setQid(qa.getQuestion(con, rs.getInt("QID")));
                                answerObj.setVid(va.getVisit(con, rs.getInt("VID")));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return answerObj;		
	}
        
	public void addAnswer(Connection con, Answer ans) throws SQLException
	{
            String SQL_QUERY = "insert into ANSWER values(?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, ans.getAnsId());
                pst.setString(2, ans.getAnswer());
                pst.setInt(3, ans.getQid().getQid());
                pst.setInt(4, ans.getVid().getVid());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateAnswer(Connection con, int ANS_ID, Answer ans) throws SQLException
	{
            String SQL_QUERY = "update ANSWER set ANSWER = ?, QID = ?, VID = ? where ANS_ID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, ans.getAnswer());
                pst.setInt(2, ans.getQid().getQid());
                pst.setInt(3, ans.getVid().getVid());
                pst.setInt(4, ANS_ID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteAnswer(Connection con, int ANS_ID) throws SQLException
	{
            String SQL_QUERY = "delete from ANSWER where ANS_ID = "+ANS_ID;
            try
            {
                Statement smt = con.createStatement(); 
                int rowCount = smt.executeUpdate(SQL_QUERY);
                
                System.out.println(rowCount+" delete-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}
}