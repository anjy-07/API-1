/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Office;
import com.mycompany.DTO.List.Offices;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface OfficeServiceInterface 
{
    public Offices offices();
    public Response addOffice(Office a);
    public Response updateOffice(Office a, int AID);
    public Response deleteOffice(int AID);
    public Office getOffice(int AID);
}