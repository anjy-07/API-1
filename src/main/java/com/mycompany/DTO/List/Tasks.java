/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO.List;

import com.mycompany.DTO.Task;
import java.util.List;
/**
 *
 * @author shivangi
 */
public class Tasks
{
    private List<Task> taskList;
 
    public List<Task> getTaskList() {
        return taskList;
    }
 
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}