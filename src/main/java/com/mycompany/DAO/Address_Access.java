package com.mycompany.DAO;

import com.mycompany.DTO.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Address_Access
{
	public Map<Integer,Address> getAddresses(Connection con) throws SQLException
	{             
		Map<Integer,Address> addressMap = new HashMap<Integer,Address>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ADDRESS");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Address addressObj = new Address();
                                
				addressObj.setAid(rs.getInt("AID"));
				addressObj.setAddress(rs.getString("ADDRESS"));
				addressObj.setPincode(rs.getInt("PINCODE"));
				addressObj.setDistrict(rs.getString("DISTRICT"));
				addressObj.setCity(rs.getString("CITY"));
				addressObj.setState(rs.getString("STATE"));
                                
				addressMap.put(rs.getInt("AID"), addressObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return addressMap;		
	}
        
	public Address getAddress(Connection con, int AID) throws SQLException
	{
                Address addressObj = new Address();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM ADDRESS where AID = "+AID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{                                
				addressObj.setAid(rs.getInt("AID"));
				addressObj.setPincode(rs.getInt("PINCODE"));
				addressObj.setAddress(rs.getString("ADDRESS"));
				addressObj.setDistrict(rs.getString("DISTRICT"));
				addressObj.setCity(rs.getString("CITY"));
				addressObj.setState(rs.getString("STATE"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return addressObj;		
	}
        
	public void addAddress(Connection con, Address o) throws SQLException
	{
            String SQL_QUERY = "insert into ADDRESS values(?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getAid());
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
        
	public void updateAddress(Connection con, int AID, Address o) throws SQLException
	{
            String SQL_QUERY = "update ADDRESS set ADDRESS = ?, PINCODE = ?, DISTRICT = ?, CITY = ?, STATE = ?  where AID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getAddress());
                pst.setInt(2, o.getPincode());
                pst.setString(3, o.getDistrict());
                pst.setString(4, o.getCity());
                pst.setString(5, o.getState());
                pst.setInt(6, AID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteAddress(Connection con, int AID) throws SQLException
	{
            String SQL_QUERY = "delete from ADDRESS where AID = "+AID;
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