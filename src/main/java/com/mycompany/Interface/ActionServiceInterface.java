/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Action;
import com.mycompany.DTO.List.Actions;
import com.mycompany.DTO.Response;

/**
 *
 * @author shivangi
 */
public interface ActionServiceInterface 
{
    public Actions actions();
    public Response addAction(Action a);
    public Response updateAction(Action a, int AID);
    public Response deleteAction(int AID);
    public Action getAction(int AID);
}