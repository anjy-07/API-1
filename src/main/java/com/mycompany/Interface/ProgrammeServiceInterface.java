/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.List.Programmes;
import com.mycompany.DTO.Programme;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface ProgrammeServiceInterface 
{
    public Programmes programmes();
    public Response addProgramme(Programme p);
    public Response updateProgramme(Programme p, int PID);
    public Response deleteProgramme(int PID);
    public Programme getProgramme(int PID);
}