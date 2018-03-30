package com.mycompany.Model;

import com.mycompany.DAO.Address_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DTO.Address;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Address_AccessManager
{
	public Map<Integer,Address> getAddresses() throws Exception
	{
		Map<Integer,Address> addressMap = new HashMap<Integer,Address>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Address_Access access = new Address_Access();
                
		addressMap = access.getAddresses(con);
                System.out.println("getall----AccessManager");
                
		return addressMap;
	}
        
        public void addAddress(Address ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Address_Access access = new Address_Access();
                
                access.addAddress(con, ans);
                System.out.println("add----AccessManager");
        }        
        
        public void updateAddress(int AID, Address ans) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Address_Access access = new Address_Access();
                
                access.updateAddress(con, AID, ans);
                System.out.println("update----AccessManager");
        }
        
        public void deleteAddress(int AID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Address_Access access = new Address_Access();
                
                access.deleteAddress(con, AID);
                System.out.println("delete----AccessManager");
        }
}