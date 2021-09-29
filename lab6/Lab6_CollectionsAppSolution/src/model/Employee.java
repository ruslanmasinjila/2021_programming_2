/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author mga
 */
public class Employee implements Comparable<Employee> {
    protected int employeeId;
    protected String employeeName;
    protected EmployeeRoleType employeeRole;   
    
    private static int numberOfEmployees=0;    

    public Employee()
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = null;
        this.employeeRole = EmployeeRoleType.DEVELOPER;
    }	
    
    public Employee(String employeeName, EmployeeRoleType employeeRole)
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }    
	
    public Employee(int employeeId, String employeeName, EmployeeRoleType employeeRole)
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
    
    public EmployeeRoleType getEmployeeRole()
    {
        return this.employeeRole;
    }

    public void setEmployeeRole(EmployeeRoleType employeeRole)
    {
        this.employeeRole = employeeRole;
    }     

    @Override
    public int hashCode() {
        return getEmployeeId() * 31 + getEmployeeName().hashCode() * 31 +  getEmployeeRole().hashCode() * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee)o;
            return  e.getEmployeeId() == getEmployeeId() &&
                    e.getEmployeeName() == getEmployeeName() &&
                    e.getEmployeeRole().equals(getEmployeeRole());
        } else {
            return false;
        }
    }
    
    public static Comparator<Employee> EmployeeNameComparator 
                      = new Comparator<Employee>() {

        @Override
        public int compare(Employee emp1, Employee emp2) {

          String empName1 = emp1.getEmployeeName();
          String empName2 = emp2.getEmployeeName();

          //ascending order
          return empName1.compareTo(empName2);

          //descending order
          //return empName2.compareTo(empName1);
        }

    };    
    
    @Override
    public int compareTo(Employee compareEmployee) {
	
		int empId = ((Employee) compareEmployee).getEmployeeId(); 
		
		//ascending order
		return this.employeeId - empId;
		
		//descending order
		//return employeeId - this.empId;
		
    }    
    
    @Override
    public String toString() {
        return  "employee id: " + getEmployeeId() + ", " +
                "employee name: " + getEmployeeName() + ", " +	
                "employee role: " + getEmployeeRole();
    }      
}

