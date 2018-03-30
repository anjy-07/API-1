package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
	public Connection getConnection() throws Exception
	{
		try
		{
			String connectionURL = "jdbc:mysql://localhost:3307/FINAL_DB";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "system");
                        System.out.println("--------DB");
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}

}