package com.mycompany.Model;

import com.mycompany.DAO.Visit_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Visit;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Visit_AccessManager
{
	public Map<Integer,Visit> getVisits() throws Exception
	{
		Map<Integer,Visit> visitMap = new HashMap<Integer,Visit>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Visit_Access access = new Visit_Access();
                
		visitMap = access.getVisits(con);
                System.out.println("getall----AccessManager");
                
		return visitMap;
	}
        
        public void addVisit(Visit ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Visit_Access access = new Visit_Access();
                
                access.addVisit(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateVisit(int AID, Visit ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Visit_Access access = new Visit_Access();
                
                access.updateVisit(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteVisit(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Visit_Access access = new Visit_Access();
                
                access.deleteVisit(con, AID);
                System.out.println("delete----AccessManager");
        }
}