/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO.List;

import com.mycompany.DTO.Officer;
import java.util.List;
/**
 *
 * @author shivangi
 */
public class Officers
{
    private List<Officer> officerList;
 
    public List<Officer> getOfficerList() {
        return officerList;
    }
 
    public void setOfficerList(List<Officer> officerList) {
        this.officerList = officerList;
    }
}