package com.mycompany.Model;

import com.mycompany.DAO.Database;
import com.mycompany.DAO.Programme_Access;
import com.mycompany.DTO.Programme;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Programme_AccessManager
{
	public Map<Integer,Programme> getProgrammes() throws Exception
	{
		Map<Integer,Programme> programmeMap = new HashMap<Integer,Programme>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Programme_Access access = new Programme_Access();
                
		programmeMap = access.getProgrammes(con);
                System.out.println("getall----AccessManager");
                
		return programmeMap;
	}
        
        public void addProgramme(Programme p) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Programme_Access access = new Programme_Access();
                
                access.addProgramme(con, p);
                System.out.println("add----AccessManager");
        }        
        
        public void updateProgramme(int PID, Programme p) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Programme_Access access = new Programme_Access();
                
                access.updateProgramme(con, PID, p);
                System.out.println("update----AccessManager");
        }
        
        public void deleteProgramme(int PID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Programme_Access access = new Programme_Access();
                
                access.deleteProgramme(con, PID);
                System.out.println("delete----AccessManager");
        }
}