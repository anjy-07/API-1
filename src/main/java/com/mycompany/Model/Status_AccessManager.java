package com.mycompany.Model;

import com.mycompany.DAO.Status_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Status;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Status_AccessManager
{
	public Map<Integer,Status> getStatuses() throws Exception
	{
		Map<Integer,Status> statusMap = new HashMap<Integer,Status>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Status_Access access = new Status_Access();
                
		statusMap = access.getStatuses(con);
                System.out.println("getall----AccessManager");
                
		return statusMap;
	}
        
        public void addStatus(Status ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Status_Access access = new Status_Access();
                
                access.addStatus(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateStatus(int AID, Status ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Status_Access access = new Status_Access();
                
                access.updateStatus(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteStatus(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Status_Access access = new Status_Access();
                
                access.deleteStatus(con, AID);
                System.out.println("delete----AccessManager");
        }
}