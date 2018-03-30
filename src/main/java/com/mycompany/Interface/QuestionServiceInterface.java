/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Interface;

import com.mycompany.DTO.List.Questions;
import com.mycompany.DTO.Question;
import com.mycompany.DTO.Response;
/**
 *
 * @author shivangi
 */
public interface QuestionServiceInterface 
{
    public Questions questions();
    public Response addQuestion(Question q);
    public Response updateQuestion(Question q, int QID);
    public Response deleteQuestion(int QID);
    public Question getQuestion(int QID);
}