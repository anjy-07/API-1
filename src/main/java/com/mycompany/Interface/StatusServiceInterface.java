/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Status;
import com.mycompany.DTO.List.Statuses;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface StatusServiceInterface 
{
    public Statuses statuses();
    public Response addStatus(Status a);
    public Response updateStatus(Status a, int AID);
    public Response deleteStatus(int AID);
    public Status getStatus(int AID);
}