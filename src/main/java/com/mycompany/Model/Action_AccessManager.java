package com.mycompany.Model;

import com.mycompany.DAO.Action_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Action;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Action_AccessManager
{
	public Map<Integer,Action> getActions() throws Exception
	{
		Map<Integer,Action> actionMap = new HashMap<Integer,Action>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Action_Access access = new Action_Access();
                
		actionMap = access.getActions(con);
                System.out.println("getall----AccessManager");
                
		return actionMap;
	}
        
        public void addAction(Action ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Action_Access access = new Action_Access();
                
                access.addAction(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateAction(int AID, Action ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Action_Access access = new Action_Access();
                
                access.updateAction(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteAction(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Action_Access access = new Action_Access();
                
                access.deleteAction(con, AID);
                System.out.println("delete----AccessManager");
        }
}