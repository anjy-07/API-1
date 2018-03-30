/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.Answer;
import com.mycompany.DTO.List.Answers;
import com.mycompany.DTO.Response;


/**
 *
 * @author shivangi
 */
public interface AnswerServiceInterface 
{
    public Answers answers();
    public Response addAnswer(Answer a);
    public Response updateAnswer(Answer a, int AID);
    public Response deleteAnswer(int AID);
    public Answer getAnswer(int AID);
}