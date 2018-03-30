/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO.List;

import com.mycompany.DTO.Visit;
import java.util.List;
/**
 *
 * @author shivangi
 */
public class Visits
{
    private List<Visit> visitList;
 
    public List<Visit> getVisitList() {
        return visitList;
    }
 
    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}