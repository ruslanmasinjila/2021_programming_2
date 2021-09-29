/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.Employee;
import model.EmployeeRoleType;

/**
 *
 * @author mga
 */
public class EmployeeController {
    Set<Employee> employees;   
    
    public EmployeeController() {
        //employees = new HashSet<>();
        employees = new TreeSet<>();         
    }
   
    public void run() {
        System.out.println("Add Elements");
        System.out.println("------------");
        addElements();
        
        displayElements();
        displayElementsWithRole(EmployeeRoleType.DEVELOPER); 
        
        System.out.println("Sort By Name");
        System.out.println("------------");
        Set<Employee> newSet = new TreeSet(Employee.EmployeeNameComparator);
        newSet.addAll(employees);        
        System.out.println(newSet);  
    }

    private void addElements() {     
        employees.add(new Employee("Iniesta", EmployeeRoleType.DEVELOPER));
        employees.add(new Employee("Messi", EmployeeRoleType.DEVELOPER));
        employees.add(new Employee("Busquets", EmployeeRoleType.ANALYST));
        employees.add(new Employee("Puyol", EmployeeRoleType.PROJECTLEADER));
        employees.add(new Employee("Pique", EmployeeRoleType.TESTER));
    }
    
    private void displayElements() {
        System.out.println("for each");
        System.out.println("========");
        for(Employee e : employees)
            System.out.println("employee:" + e);
    }
    
    private void displayElementsWithRole(EmployeeRoleType role) {
        System.out.println(role);
        System.out.println("========");
        Iterator it = employees.iterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.getEmployeeRole() == role)
                System.out.println(e);
        }
    }    
}
