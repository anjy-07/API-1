package com.mycompany.api_hackathon;

import com.mycompany.DTO.Response;
import com.mycompany.DTO.Address;
import com.mycompany.DTO.List.Addresses;
import com.mycompany.Interface.AddressServiceInterface;
import com.mycompany.Model.Address_AccessManager;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;

@Path("/addressService")
public class AddressService implements AddressServiceInterface
{ 
    private static Map<Integer,Address> addressMap = new HashMap<Integer,Address>();
    Address_AccessManager accessManager = new Address_AccessManager();
    
    @Override
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Addresses addresses() 
    {
//		String addresses = null;
                addressMap = new HashMap<Integer,Address>();
                Addresses c = new Addresses();
		try
		{
                    addressMap = accessManager.getAddresses();
                    ArrayList<Address> addressList = new ArrayList(addressMap.values());
                    
                    c.setAddressList(addressList);
                    
//                    Gson gson = new Gson();
//                    addresses = gson.toJson(addressList);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
		return c;
    }
    
    @Override
    @GET
    @Path("/{id}/get")
    @Produces("application/json")
    public Address getAddress(@PathParam("id") int id) 
    {
        return addressMap.get(id);
    }
	
    @GET
    @Path("/{id}/getDummy")
    @Produces("application/json")
    public Address getDummyPerson(@PathParam("id") int id) 
    {
		Address p = new Address();
                
                p.setAddress("Dummy Address");
		p.setAid(id);
                
		return p;
    }

    @Override
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addAddress(Address p) 
    {
		Response response = new Response();
		if(addressMap.get(p.getAid()) != null)
                {                    
                    response.setStatus(false);
                    response.setMessage("Address Already Exists");
                    return response;
		}
                
                    try 
                    {
                        accessManager.addAddress(p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		addressMap.put(p.getAid(), p);
		response.setStatus(true);
		response.setMessage("Address created successfully");
		return response;
    }
    
    @Override
    @PUT
    @Path("/{id}/update")
    @Produces("application/json")
    public Response updateAddress(Address p, @PathParam("id") int id) 
    {
		Response response = new Response();
		if(addressMap.get(p.getAid()) != null)
                {
                    try 
                    {
                        accessManager.updateAddress(id, p);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    addressMap.put(p.getAid(), p);		
                    response.setStatus(true);		
                    response.setMessage("Address updated successfully");
                    return response;
		}
                
                response.setStatus(false);
                response.setMessage("Address Does Not Exist");
		return response;
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    @Produces("application/json")
    public Response deleteAddress(@PathParam("id") int id) 
    {
		Response response = new Response();
		if(addressMap.get(id) == null)
                {                    
			response.setStatus(false);
			response.setMessage("Address Doesn't Exists");
			return response;
		}
                
                    try 
                    {
                        accessManager.deleteAddress(id);
                    } 
                    catch (Exception ex) 
                    {
                        Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		addressMap.remove(id);
		response.setStatus(true);
		response.setMessage("Address deleted successfully");
		return response;
    }
}