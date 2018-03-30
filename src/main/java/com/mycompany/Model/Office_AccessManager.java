package com.mycompany.Model;

import com.mycompany.DAO.Office_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Office;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Office_AccessManager
{
	public Map<Integer,Office> getOffices() throws Exception
	{
		Map<Integer,Office> officeMap = new HashMap<Integer,Office>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Office_Access access = new Office_Access();
                
		officeMap = access.getOffices(con);
                System.out.println("getall----AccessManager");
                
		return officeMap;
	}
        
        public void addOffice(Office ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Office_Access access = new Office_Access();
                
                access.addOffice(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateOffice(int AID, Office ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Office_Access access = new Office_Access();
                
                access.updateOffice(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteOffice(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Office_Access access = new Office_Access();
                
                access.deleteOffice(con, AID);
                System.out.println("delete----AccessManager");
        }
}