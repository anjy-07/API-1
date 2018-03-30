package com.mycompany.DAO;

import com.mycompany.DTO.Programme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Programme_Access
{
	public Map<Integer,Programme> getProgrammes(Connection con) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Map<Integer,Programme> programmeMap = new HashMap<Integer,Programme>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM PROGRAMME");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Programme programmeObj = new Programme();
                                
                                programmeObj.setPid(rs.getInt("PID"));
                                programmeObj.setName(rs.getString("NAME"));
                                programmeObj.setLaunchdate(dateFormat.format(new Date(rs.getTimestamp("LAUNCHDATE").getTime())));
                                programmeObj.setDescription(rs.getString("DESCRIPTION"));
                                
				programmeMap.put(rs.getInt("PID"), programmeObj);
			}
                        System.out.println("getall-----Access");
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
		return programmeMap;		
	}
        
	public Programme getProgramme(Connection con, int PID) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
                Programme programmeObj = new Programme();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM PROGRAMME where PID = "+PID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{                                
                                programmeObj.setPid(rs.getInt("PID"));
                                programmeObj.setName(rs.getString("NAME"));
                                programmeObj.setLaunchdate(dateFormat.format(new Date(rs.getTimestamp("LAUNCHDATE").getTime())));
                                programmeObj.setDescription(rs.getString("DESCRIPTION"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return programmeObj;		
	}
        
	public void addProgramme(Connection con, Programme p) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy"); 
            String SQL_QUERY = "insert into PROGRAMME values(?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, p.getPid());
                pst.setString(2, p.getName());
                pst.setTimestamp(3, new Timestamp(dateFormat.parse(p.getLaunchdate()).getTime()));
                pst.setString(4, p.getDescription());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateProgramme(Connection con, int PID, Programme p) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy"); 
            String SQL_QUERY = "update PROGRAMME set NAME = ?, LAUNCHDATE = ?, DESCRIPTION = ? where PID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, p.getName());
                pst.setTimestamp(2, new Timestamp(dateFormat.parse(p.getLaunchdate()).getTime()));
                pst.setString(3, p.getDescription());
                pst.setInt(4, PID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteProgramme(Connection con, int PID) throws SQLException
	{
            String SQL_QUERY = "delete from PROGRAMME where PID = "+PID;
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