/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mga
 */
public abstract class Project {
    protected String projectId;
    protected String projectTitle;
    protected Calendar startDate;
    
    public Project() {
        this.projectId= "Unallocated";
        this.projectTitle = "Unknown";
        this.startDate = null;
    }
    
    public Project(String projectId, String projectTitle, Calendar startDate) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.startDate = startDate;
    }
    
    public String getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectTitle() {
        return this.projectTitle;
    }
    
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
    
    public Calendar getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    
    protected String getFormattedStartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.startDate.getTime());
        return dateString;
    }
    
    @Override
    public String toString() {
        return "\nId: " + this.projectId +
                " Title: " + this.projectTitle +                               
                " Start: " + getFormattedStartDate() + "\n";        
    } 
    
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = QUOTE + this.projectId + QUOTE + delimiter + QUOTE + this.projectTitle + QUOTE + delimiter +
                QUOTE + getFormattedStartDate() + QUOTE + EOLN;
        return str;
    }    
}
