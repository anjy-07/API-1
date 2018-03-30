package com.mycompany.DAO;

import com.mycompany.DTO.Office;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Office_Access
{
	public Map<Integer,Office> getOffices(Connection con) throws SQLException
	{             
		Map<Integer,Office> officeMap = new HashMap<Integer,Office>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICE");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Office officeObj = new Office();
                                
				officeObj.setOfficeId(rs.getInt("OFFICE_ID"));
				officeObj.setAddress(rs.getString("NAME"));
				officeObj.setPincode(rs.getInt("PINCODE"));
				officeObj.setDistrict(rs.getString("DISTRICT"));
				officeObj.setCity(rs.getString("CITY"));
				officeObj.setState(rs.getString("STATE"));
                                
				officeMap.put(rs.getInt("OFFICE_ID"), officeObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officeMap;		
	}
        
	public Office getOffice(Connection con, int OFFICE_ID) throws SQLException
	{
                Office officeObj = new Office();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICE where OFFICE_ID = "+OFFICE_ID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{                                
				officeObj.setOfficeId(rs.getInt("OFFICE_ID"));
				officeObj.setAddress(rs.getString("ADDRESS"));
				officeObj.setPincode(rs.getInt("PINCODE"));
				officeObj.setDistrict(rs.getString("DISTRICT"));
				officeObj.setCity(rs.getString("CITY"));
				officeObj.setState(rs.getString("STATE"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officeObj;		
	}
        
	public void addOffice(Connection con, Office o) throws SQLException
	{
            String SQL_QUERY = "insert into OFFICE values(?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getOfficeId());
                pst.setString(2, o.getAddress());
                pst.setInt(3, o.getPincode());
                pst.setString(4, o.getDistrict());
                pst.setString(5, o.getCity());
                pst.setString(6, o.getState());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateOffice(Connection con, int OFFICE_ID, Office o) throws SQLException
	{
            String SQL_QUERY = "update OFFICE set ADDRESS = ?, PINCODE = ?, DISTRICT = ?, CITY = ?, STATE = ?  where OFFICE_ID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getAddress());
                pst.setInt(2, o.getPincode());
                pst.setString(3, o.getDistrict());
                pst.setString(4, o.getCity());
                pst.setString(5, o.getState());
                pst.setInt(6, OFFICE_ID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteOffice(Connection con, int OFFICE_ID) throws SQLException
	{
            String SQL_QUERY = "delete from OFFICE where OFFICE_ID = "+OFFICE_ID;
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