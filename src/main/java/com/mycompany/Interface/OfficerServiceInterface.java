/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.List.Officers;
import com.mycompany.DTO.Officer;
import com.mycompany.DTO.Response;

/**
 *
 * @author shivangi
 */
public interface OfficerServiceInterface 
{
    public Officers officers();
    public Response addOfficer(Officer o);
    public Response updateOfficer(Officer o, int OID);
    public Response deleteOfficer(int OID);
    public Officer getOfficer(int OID);
}