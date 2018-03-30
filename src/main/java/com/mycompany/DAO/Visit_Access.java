package com.mycompany.DAO;

import com.mycompany.DTO.Visit;
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

public class Visit_Access
{
	public Map<Integer,Visit> getVisits(Connection con) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Map<Integer,Visit> visitMap = new HashMap<Integer,Visit>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM VISIT");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Visit visitObj = new Visit();
                                Task_Access ta = new Task_Access();
                                Action_Access aa = new Action_Access();
                                
				visitObj.setVid(rs.getInt("VID"));
                                visitObj.setTid(ta.getTask(con, rs.getInt("TID")));
                                visitObj.setActionId(aa.getAction(con, rs.getInt("ACTION_ID")));
                                visitObj.setPicture(rs.getString("AID"));
                                visitObj.setLat(rs.getBigDecimal("LAT"));
                                visitObj.setLongitude(rs.getBigDecimal("LONGITUDE"));
                                visitObj.setRemarkOfficer(rs.getString("REMARK_OFFICER"));
                                visitObj.setRemarkAdmin(rs.getString("REMARK_ADMIN"));    
                                
				visitMap.put(rs.getInt("VID"), visitObj);
			}
                        System.out.println("getall-----Access");
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
		return visitMap;		
	}
        
	public Visit getVisit(Connection con, int VID) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Visit visitObj = new Visit();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM VISIT where VID = "+VID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{
                                Task_Access ta = new Task_Access();
                                Action_Access aa = new Action_Access();
                                
				visitObj.setVid(rs.getInt("VID"));
                                visitObj.setTid(ta.getTask(con, rs.getInt("TID")));
                                visitObj.setActionId(aa.getAction(con, rs.getInt("ACTION_ID")));
                                visitObj.setPicture(rs.getString("AID"));
                                visitObj.setLat(rs.getBigDecimal("LAT"));
                                visitObj.setLongitude(rs.getBigDecimal("LONGITUDE"));
                                visitObj.setRemarkOfficer(rs.getString("REMARK_OFFICER"));
                                visitObj.setRemarkAdmin(rs.getString("REMARK_ADMIN"));                                
			}
                        System.out.println("get-----Access");
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
		return visitObj;		
	}
        
	public void addVisit(Connection con, Visit t) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "insert into VISIT values(?,?,?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, t.getVid());
                pst.setInt(2, t.getTid().getTid());
                pst.setInt(3, t.getActionId().getActionId());
                pst.setString(4, t.getPicture());
                pst.setBigDecimal(5, t.getLat());
                pst.setBigDecimal(6, t.getLongitude());
                pst.setString(7, t.getRemarkOfficer());
                pst.setString(8, t.getRemarkAdmin());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateVisit(Connection con, int VID, Visit t) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "update VISIT set TID = ?, ACTION_ID = ?, PICTURE = ?, LAT = ?, "
                    + "LONGITUDE = ?, REMARK_OFFICER = ?, REMARK_ADMIN = ? where VID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, t.getTid().getTid());
                pst.setInt(2, t.getActionId().getActionId());
                pst.setString(3, t.getPicture());
                pst.setBigDecimal(4, t.getLat());
                pst.setBigDecimal(5, t.getLongitude());
                pst.setString(7, t.getRemarkOfficer());
                pst.setString(8, t.getRemarkAdmin());
                pst.setInt(9, VID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteVisit(Connection con, int VID) throws SQLException
	{
            String SQL_QUERY = "delete from VISIT where VID = "+VID;
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