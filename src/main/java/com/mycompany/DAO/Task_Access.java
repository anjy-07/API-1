package com.mycompany.DAO;

import com.mycompany.DTO.Task;
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

public class Task_Access
{
	public Map<Integer,Task> getTasks(Connection con) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Map<Integer,Task> taskMap = new HashMap<Integer,Task>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM TASK");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Task taskObj = new Task();
                                Programme_Access pa = new Programme_Access();
                                Officer_Access oa = new Officer_Access();
                                Address_Access aa = new Address_Access();
                                Status_Access sa = new Status_Access();
                                
				taskObj.setTid(rs.getInt("TID"));
                                taskObj.setPid(pa.getProgramme(con, rs.getInt("PID")));
                                taskObj.setOid(oa.getOfficer(con, rs.getInt("OID")));
                                taskObj.setAid(aa.getAddress(con, rs.getInt("AID")));
                                taskObj.setStatusId(sa.getStatus(con, rs.getInt("STATUS_ID")));
				taskObj.setDescription(rs.getString("DESCRIPTION"));
				taskObj.setSetDate(dateFormat.format(new Date(rs.getDate("SET_DATE").getTime())));
				taskObj.setDeadline(dateFormat.format(new Date(rs.getDate("DEADLINE").getTime())));
                                taskObj.setVisitType(rs.getString("VISIT_TYPE"));
                                
				taskMap.put(rs.getInt("TID"), taskObj);
			}
                        System.out.println("getall-----Access");
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
		return taskMap;		
	}
        
	public Task getTask(Connection con, int TID) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Task taskObj = new Task();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM TASK where TID = "+TID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{
                                Programme_Access pa = new Programme_Access();
                                Officer_Access oa = new Officer_Access();
                                Address_Access aa = new Address_Access();
                                Status_Access sa = new Status_Access();
                                
				taskObj.setTid(rs.getInt("TID"));
                                taskObj.setPid(pa.getProgramme(con, rs.getInt("PID")));
                                taskObj.setOid(oa.getOfficer(con, rs.getInt("OID")));
                                taskObj.setAid(aa.getAddress(con, rs.getInt("AID")));
                                taskObj.setStatusId(sa.getStatus(con, rs.getInt("STATUS_ID")));
				taskObj.setDescription(rs.getString("DESCRIPTION"));
				taskObj.setSetDate(dateFormat.format(new Date(rs.getDate("SET_DATE").getTime())));
				taskObj.setDeadline(dateFormat.format(new Date(rs.getDate("DEADLINE").getTime())));
                                taskObj.setVisitType(rs.getString("VISIT_TYPE"));
			}
                        System.out.println("get-----Access");
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
		return taskObj;		
	}
        
	public void addTask(Connection con, Task t) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "insert into TASK values(?,?,?,?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, t.getTid());
                pst.setInt(2, t.getPid().getPid());
                pst.setInt(3, t.getOid().getOid());
                pst.setInt(4, t.getAid().getAid());
                pst.setInt(5, t.getStatusId().getStatusId());
                pst.setString(6, t.getDescription());
                pst.setTimestamp(7, new Timestamp(dateFormat.parse(t.getSetDate()).getTime()));
                pst.setTimestamp(8, new Timestamp(dateFormat.parse(t.getDeadline()).getTime()));
                pst.setString(9, t.getVisitType());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateTask(Connection con, int TID, Task t) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
            String SQL_QUERY = "update TASK set PID = ?, OID = ?, AID = ?, STATUS_ID = ?, DESCRIPTION = ?, SET_DATE = ?, "
                    + "DEADLINE = ?, VISIT_TYPE = ? where TID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, t.getPid().getPid());
                pst.setInt(2, t.getOid().getOid());
                pst.setInt(3, t.getAid().getAid());
                pst.setInt(4, t.getStatusId().getStatusId());
                pst.setString(5, t.getDescription());
                pst.setTimestamp(6, new Timestamp(dateFormat.parse(t.getSetDate()).getTime()));
                pst.setTimestamp(7, new Timestamp(dateFormat.parse(t.getDeadline()).getTime()));
                pst.setString(8, t.getVisitType());
                pst.setInt(9, TID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteTask(Connection con, int TID) throws SQLException
	{
            String SQL_QUERY = "delete from TASK where TID = "+TID;
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