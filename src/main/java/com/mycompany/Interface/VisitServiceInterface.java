/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Visit;
import com.mycompany.DTO.List.Visits;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface VisitServiceInterface 
{
    public Visits visits();
    public Response addVisit(Visit a);
    public Response updateVisit(Visit a, int AID);
    public Response deleteVisit(int AID);
    public Visit getVisit(int AID);
}