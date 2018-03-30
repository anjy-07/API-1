package com.mycompany.DAO;

import com.mycompany.DTO.Action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Action_Access
{
	public Map<Integer,Action> getActions(Connection con) throws SQLException
	{             
		Map<Integer,Action> actionMap = new HashMap<Integer,Action>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ACTION");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Action actionObj = new Action();
                                
				actionObj.setActionId(rs.getInt("ACTION_ID"));
				actionObj.setAction(rs.getString("ACTION"));
                                
				actionMap.put(rs.getInt("ACTION_ID"), actionObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return actionMap;		
	}
        
	public Action getAction(Connection con, int ACTION_ID) throws SQLException
	{
                Action actionObj = new Action();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ACTION where ACTION_ID = "+ACTION_ID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{      
                                actionObj.setActionId(rs.getInt("ACTION_ID"));
				actionObj.setAction(rs.getString("ACTION"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return actionObj;		
	}
        
	public void addAction(Connection con, Action o) throws SQLException
	{
            String SQL_QUERY = "insert into ACTION values(?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getActionId());
                pst.setString(2, o.getAction());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateAction(Connection con, int ACTION_ID, Action o) throws SQLException
	{
            String SQL_QUERY = "update ACTION set ACTION = ? where ACTION_ID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getAction());
                pst.setInt(6, ACTION_ID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteAction(Connection con, int ACTION_ID) throws SQLException
	{
            String SQL_QUERY = "delete from ACTION where ACTION_ID = "+ACTION_ID;
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