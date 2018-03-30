/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO.List;

import com.mycompany.DTO.Question;
import java.util.List;
/**
 *
 * @author shivangi
 */
public class Questions
{
    private List<Question> questionList;
 
    public List<Question> getQuestionList() {
        return questionList;
    }
 
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}