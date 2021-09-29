/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String employeeRole;   
    
    private static int numberOfEmployees=0;    

    public Employee()
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = null;
        this.employeeRole = "Developer";
    }	
    
    public Employee(String employeeName, String employeeRole)
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }    
	
    public Employee(int employeeId, String employeeName, String employeeRole)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        numberOfEmployees++;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }    
    
    public int getEmployeeId()
    {
        return this.employeeId;
    }    
    
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }      
    
    public String getEmployeeName()
    {
        return this.employeeName;
    }     
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }     
    
    public String getEmployeeRole()
    {
        return this.employeeRole;
    }

    public void setEmployeeRole(String employeeRole)
    {
        this.employeeRole = employeeRole;
    }     
    
    @Override
    public String toString() {
        return  "employee id: " + getEmployeeId() + ", " +
                "employee name: " + getEmployeeName() + ", " +	
                "employee role: " + getEmployeeRole();
    }      
}

