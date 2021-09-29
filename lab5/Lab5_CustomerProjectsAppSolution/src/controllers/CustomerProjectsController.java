/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import model.AdHocProject;
import model.Customer;
import model.PlannedProject;
import model.Project;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class CustomerProjectsController {
    private final Repository repository;
    
    public CustomerProjectsController() {

        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Customers File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");               
            this.repository = new Repository(fileName);
        }
        else {
            this.repository = new Repository();
        }
    }
   
    public void run() {
        boolean finished = false;
        do {
            System.out.println("Customers\n=========");            
            System.out.println(repository);
            char choice = displayCustomerProjectsMenu();
            switch (choice) {
                case 'A': 
                    addProjectToCustomer();
                    break;
                case 'B': 
                    removeProjectFromCustomer();
                    break;                      
                case 'F':
                    InputHelper inputHelper = new InputHelper();
                    String fileName = inputHelper.readString("Enter filename");                
                    repository.store(fileName);                  
                    finished = true;
            }
        } while (!finished);
    }

    private char displayCustomerProjectsMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add a new project");
        System.out.print("\tB. Remove a project");
        System.out.print("\tF. Finish\n");         
        return inputHelper.readCharacter("Enter choice", "ABF");
    }    
    
    private void addProjectToCustomer() {
        InputHelper inputHelper = new InputHelper();
        boolean validCustomerId = false;
        Customer requiredCustomer=null;
        do {
            int customerId = inputHelper.readInt("Enter Customer Id");
            requiredCustomer = repository.getItem(customerId);           
            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        String newProjectId = inputHelper.readString("Enter New Project Id");
        String newProjectTitle = inputHelper.readString("Enter New Project Title");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        Calendar newStartDate = inputHelper.readDate("Enter New Start Date", sdf);
        char c = inputHelper.readCharacter("Planned or Ad Hoc Project (P/A)?", "PA");
        if (c == 'P' || c == 'p') {
            Set<String> projectEmployees = new HashSet<>();
            boolean moreEmployees = true;
            do {
                String employee = inputHelper.readString("Enter Employee (End to finish)");
                if (!employee.equalsIgnoreCase("End"))
                    projectEmployees.add(employee);
                else
                    moreEmployees = false;
            } while (moreEmployees);
            int noAllocatedDays = inputHelper.readInt("Enter Allocated Days");
            Project newProject = new PlannedProject(newProjectId, newProjectTitle, newStartDate, projectEmployees, noAllocatedDays);
            requiredCustomer.addProjectToCustomer(newProject);     
        }
        else {
            String employee = inputHelper.readString("Enter Employee");
            Project newProject = new AdHocProject(newProjectId, newProjectTitle, newStartDate, employee);
            requiredCustomer.addProjectToCustomer(newProject);     
        }        
       
    }
    
    private void removeProjectFromCustomer() {
        InputHelper inputHelper = new InputHelper();
        boolean validCustomerId = false;
        Customer requiredCustomer=null;
        do {
            int customerId = inputHelper.readInt("Enter Customer Id");
            requiredCustomer = repository.getItem(customerId);           
            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        int projectNumber = inputHelper.readInt("Enter Project Number", requiredCustomer.getNoCustomerProjects(), 1);   
        requiredCustomer.removeProjectFromCustomer(projectNumber);
    }   
}
