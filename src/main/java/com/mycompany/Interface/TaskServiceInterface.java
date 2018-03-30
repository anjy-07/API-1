/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.List.Tasks;
import com.mycompany.DTO.Response;
import com.mycompany.DTO.Task;


/**
 *
 * @author shivangi
 */
public interface TaskServiceInterface 
{
    public Tasks tasks();
    public Response addTask(Task t);
    public Response updateTask(Task t, int TID);
    public Response deleteTask(int TID);
    public Task getTask(int TID);
}