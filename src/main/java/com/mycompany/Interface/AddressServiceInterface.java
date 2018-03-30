/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Address;
import com.mycompany.DTO.List.Addresses;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface AddressServiceInterface 
{
    public Addresses addresses();
    public Response addAddress(Address a);
    public Response updateAddress(Address a, int AID);
    public Response deleteAddress(int AID);
    public Address getAddress(int AID);
}