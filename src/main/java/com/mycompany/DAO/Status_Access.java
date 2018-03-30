package com.mycompany.DAO;

import com.mycompany.DTO.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Status_Access
{
	public Map<Integer,Status> getStatuses(Connection con) throws SQLException
	{             
		Map<Integer,Status> statusMap = new HashMap<Integer,Status>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM STATUS");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Status statusObj = new Status();
                                
				statusObj.setStatusId(rs.getInt("STATUS_ID"));
				statusObj.setStatus(rs.getString("STATUS"));
                                
				statusMap.put(rs.getInt("STATUS_ID"), statusObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return statusMap;		
	}
        
	public Status getStatus(Connection con, int STATUS_ID) throws SQLException
	{
                Status statusObj = new Status();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM STATUS where STATUS_ID = "+STATUS_ID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{      
                                statusObj.setStatusId(rs.getInt("STATUS_ID"));
				statusObj.setStatus(rs.getString("STATUS"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return statusObj;		
	}
        
	public void addStatus(Connection con, Status o) throws SQLException
	{
            String SQL_QUERY = "insert into STATUS values(?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getStatusId());
                pst.setString(2, o.getStatus());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateStatus(Connection con, int STATUS_ID, Status o) throws SQLException
	{
            String SQL_QUERY = "update STATUS set STATUS = ? where STATUS_ID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getStatus());
                pst.setInt(6, STATUS_ID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteStatus(Connection con, int STATUS_ID) throws SQLException
	{
            String SQL_QUERY = "delete from STATUS where STATUS_ID = "+STATUS_ID;
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