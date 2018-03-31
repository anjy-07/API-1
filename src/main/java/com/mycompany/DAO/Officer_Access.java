package com.mycompany.DAO;

import com.mycompany.DTO.Officer;
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
import java.util.UUID;

public class Officer_Access
{
	public Map<Integer,Officer> getOfficers(Connection con) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		Map<Integer,Officer> officerMap = new HashMap<Integer,Officer>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICER");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Officer officerObj = new Officer();
                                Office_Access oa = new Office_Access();
                                
				officerObj.setOid(rs.getInt("OID"));
				officerObj.setName(rs.getString("NAME"));
				officerObj.setOfficeId(oa.getOffice(con, rs.getInt("OFFICE_ID")));
				officerObj.setDesignation(rs.getString("DESIGNATION"));
				officerObj.setEmailId(rs.getString("EMAIL_ID"));
				officerObj.setMobile(rs.getInt("MOBILE"));
				officerObj.setAadharCard(rs.getInt("AADHAR_CARD"));
                                officerObj.setPassword(rs.getString("PASSWORD"));
                                officerObj.setTokenId(rs.getString("TOKEN_ID"));
				officerObj.setDoj(dateFormat.format(new Date(rs.getDate("DOJ").getTime())));
				officerObj.setRtd(dateFormat.format(new Date(rs.getDate("RTD").getTime())));
                                officerObj.setAdminRights(rs.getString("ADMIN_RIGHTS"));
                                
				officerMap.put(rs.getInt("OID"), officerObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officerMap;		
	}
        
	public Officer getOfficer(Connection con, int OID) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                Officer officerObj = new Officer();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICER where OID = "+OID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
                        { 
                                Office_Access oa = new Office_Access();
                                
				officerObj.setOid(rs.getInt("OID"));
				officerObj.setName(rs.getString("NAME"));
				officerObj.setOfficeId(oa.getOffice(con, rs.getInt("OFFICE_ID")));
				officerObj.setDesignation(rs.getString("DESIGNATION"));
				officerObj.setEmailId(rs.getString("EMAIL_ID"));
				officerObj.setMobile(rs.getInt("MOBILE"));
				officerObj.setAadharCard(rs.getInt("AADHAR_CARD"));
                                officerObj.setPassword(rs.getString("PASSWORD"));
                                officerObj.setTokenId(rs.getString("TOKEN_ID"));
				officerObj.setDoj(dateFormat.format(new Date(rs.getDate("DOJ").getTime())));
				officerObj.setRtd(dateFormat.format(new Date(rs.getDate("RTD").getTime())));
                                officerObj.setAdminRights(rs.getString("ADMIN_RIGHTS"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officerObj;		
	}
        
	public void addOfficer(Connection con, Officer o) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "insert into OFFICER values(?,?,?,?,?,?,?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getOid());
                pst.setString(2, o.getName());
                pst.setInt(3, o.getOfficeId().getOfficeId());
                pst.setString(4, o.getDesignation());
                pst.setString(5, o.getEmailId());
                pst.setString(6, "9971101886");
                pst.setInt(7, o.getAadharCard());
                pst.setString(8, o.getPassword());
                
                String tokenid = UUID.randomUUID().toString();
                pst.setString(9, tokenid);
                pst.setTimestamp(10, new Timestamp(dateFormat.parse(o.getDoj()).getTime()));
                pst.setTimestamp(11, new Timestamp(dateFormat.parse(o.getRtd()).getTime()));                
                pst.setString(12, o.getAdminRights());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateOfficer(Connection con, int OID, Officer o) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "update OFFICER set NAME = ?, OFFICE_ID = ?, DESIGNATION = ?, EMAIL_ID = ?, "
                    + "MOIBILE = ?, AADHAR_CARD = ?, PASSWORD = ?, TOKEN_ID = ? ,DOJ = ?, RTD = ?, ADMIN_RIGHTS = ?  where OID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getName());
                pst.setInt(2, o.getOfficeId().getOfficeId());
                pst.setString(3, o.getDesignation());
                pst.setString(4, o.getEmailId());
                pst.setInt(5, o.getMobile());
                pst.setInt(6, o.getAadharCard());
                pst.setString(7, o.getPassword());
                pst.setString(8, o.getTokenId());
                pst.setTimestamp(9, new Timestamp(dateFormat.parse(o.getDoj()).getTime()));
                pst.setTimestamp(10, new Timestamp(dateFormat.parse(o.getRtd()).getTime()));                
                pst.setString(11, o.getAdminRights());
                pst.setInt(12, OID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteOfficer(Connection con, int OID) throws SQLException
	{
            String SQL_QUERY = "delete from OFFICER where OID = "+OID;
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