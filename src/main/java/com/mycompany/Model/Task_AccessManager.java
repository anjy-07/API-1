package com.mycompany.Model;

import com.mycompany.DAO.Database;
import com.mycompany.DAO.Task_Access;
import com.mycompany.DTO.Task;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Task_AccessManager
{
	public Map<Integer,Task> getTasks() throws Exception
	{
		Map<Integer,Task> taskMap = new HashMap<Integer,Task>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Task_Access access = new Task_Access();
                
		taskMap = access.getTasks(con);
                System.out.println("getall----AccessManager");
                
		return taskMap;
	}
        
        public void addTask(Task t) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Task_Access access = new Task_Access();
                
                access.addTask(con, t);
                System.out.println("add----AccessManager");
        }        
        
        public void updateTask(int TID, Task t) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Task_Access access = new Task_Access();
                
                access.updateTask(con, TID, t);
                System.out.println("update----AccessManager");
        }
        
        public void deleteTask(int TID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Task_Access access = new Task_Access();
                
                access.deleteTask(con, TID);
                System.out.println("delete----AccessManager");
        }
}