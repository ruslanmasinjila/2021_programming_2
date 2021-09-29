/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mga
 */
public class PlannedProject extends Project {
    private Set<String> projectEmployees;
    private int noAllocatedDays;
    
    public PlannedProject() {
        super();
        this.projectEmployees = new HashSet<>();
        this.noAllocatedDays = 0;
    }
    
    public PlannedProject(String projectId, String projectTitle, Calendar startDate, Set<String> projectEmployees, int noAllocatedDays) {
        super(projectId, projectTitle, startDate);
        this.projectEmployees = projectEmployees;
        this.noAllocatedDays = noAllocatedDays;
    }
    
    public Set<String> getProjectEmployees() {
        return this.projectEmployees;
    }
    
    public void setProjectEmployees(Set<String> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }
    
    public int getNoAllocatedDays() {
        return this.noAllocatedDays;
    }
    
    public void setNoAllocatedDays() {
        this.noAllocatedDays = noAllocatedDays;
    }
    
    @Override
    public String toString() {
        return "\nId: " + this.projectId +
                " Title: " + this.projectTitle +                               
                " Start: " + getFormattedStartDate() + 
                " Employees: " + getProjectEmployees() +
                " Days: " + getNoAllocatedDays() + "\n";   
    }
    
    @Override
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = QUOTE + this.projectId + QUOTE + delimiter + QUOTE + this.projectTitle + QUOTE + delimiter +
                QUOTE + getFormattedStartDate() + QUOTE + delimiter + QUOTE + "P" + QUOTE;
        for(String employee:this.projectEmployees)
            str += delimiter + QUOTE + employee + QUOTE;
        str += delimiter + Integer.toString(this.noAllocatedDays)+ EOLN;
        return str;
    }    
}
