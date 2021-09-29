/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author mga
 */
public class AdHocProject extends Project {
    private String projectEmployee;
    
    public AdHocProject() {
        super();
        this.projectEmployee = "Unallocated";
    }
    
    public AdHocProject(String projectId, String projectTitle, Calendar startDate, String projectEmployee) {
        super(projectId, projectTitle, startDate);
        this.projectEmployee = projectEmployee;
    }
    
    public String getProjectEmployee() {
        return this.projectEmployee;
    }
    
    public void setProjectEmployee(String projectEmployee) {
        this.projectEmployee = projectEmployee;
    }
    
    @Override
    public String toString() {
        return "\nId: " + this.projectId +
                " Title: " + this.projectTitle +                               
                " Start: " + getFormattedStartDate() + 
                " Employee: " + getProjectEmployee() + "\n";   
    }
    
    @Override
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = QUOTE + this.projectId + QUOTE + delimiter + QUOTE + this.projectTitle + QUOTE + delimiter +
                QUOTE + getFormattedStartDate() + QUOTE + delimiter + QUOTE + "A" + QUOTE + delimiter + QUOTE +this.projectEmployee + QUOTE + EOLN;
        return str;
    }    
}
