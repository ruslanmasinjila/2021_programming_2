/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mga
 */
public class Customer implements Serializable {
    private final int customerId;
    private String customerName;
    private ArrayList<String> customerProjects;
    
    private static int lastCustomerIdAllocated = 0;
    
    public Customer() {
        this.customerId = lastCustomerIdAllocated++;
    }
    
    public Customer(String customerName) {
        this.customerId = lastCustomerIdAllocated++;
        this.customerName = customerName;
        this.customerProjects = new ArrayList<>();
    }
    
    public Customer(String customerName, ArrayList<String> customerProjects) {
        this.customerId = lastCustomerIdAllocated++;
        this.customerName = customerName;
        this.customerProjects = customerProjects;
    }    
    
    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerProjects = new ArrayList<>();
    }    
    
    public Customer(int customerId, String customerName, ArrayList<String> customerProjects) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerProjects = customerProjects;
    }      
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public ArrayList<String> getCustomerProjects() {
        return this.customerProjects;
    }
    
    public int getNoCustomerProjects() {
        return this.customerProjects.size();
    }
    
    public void setCustomerProjects(ArrayList<String> customerProjects) {
        this.customerProjects = customerProjects;
    }
    
    public void addProjectToCustomer(String customerProject) {
        this.customerProjects.add(customerProject);
    }
    
    public void removeProjectFromCustomer(int projectNumber) {
        this.customerProjects.remove(projectNumber-1);
    }
    
    private String getNumberedProjects() {
        String str="";
        int i=1;
        for (String project:customerProjects) {
            str += Integer.toString(i++) + ": " + project + "\n";
        }        
        return str;
    }
    
    @Override
    public String toString() {
        return "\nCustomer Id: " + this.customerId +
                "\nName: " + this.customerName +
                "\nProjects: " + getNumberedProjects();
    }
    
    public String toString(char delimiter) {
        final String QUOTE = "\"";
        final String EOLN = "\n";
        String output =  Integer.toString(this.customerId) + delimiter +
                         QUOTE + this.customerName + QUOTE + delimiter +
                         Integer.toString(this.customerProjects.size());
        for (String str : this.customerProjects)
            output += delimiter + QUOTE + str + QUOTE;
        output += EOLN;
        return output;
    }
}