/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author mga
 */
public class CustomerProjectsController {
    static char DELIMITER=',';
    private final ArrayList<Customer> repository;
    
    public CustomerProjectsController() {

        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Customers File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");               
            this.repository = load(fileName);
            // this.repository = new Repository(fileName);
        }
        else {
            this.repository = new ArrayList<>();
            // this.repository = new Repository();            
        }
    }
    
   public ArrayList<Customer> load(String filename) {

        ArrayList<Customer> repository = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { 
            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));        
                int customerId = Integer.parseInt(temp[0]);
                String customerName = stripQuotes(temp[1]);
                Customer customer = new Customer(customerId, customerName);
                int noProjects = Integer.parseInt(temp[2]);            
                for (int i=0; i<noProjects; i++) {
                    String project = stripQuotes(temp[i+3]);
                    customer.addProjectToCustomer(project);
                }
                repository.add(customer);                
                line = br.readLine();                
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
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
                    store(fileName); 
                    //repository.store(fileName);
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
            //requiredCustomer = repository.getItem(customerId);
            for (Customer customer:this.repository) {
                if (customer.getCustomerId() == customerId)
                    requiredCustomer = customer;
            }            
            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        String newProject = inputHelper.readString("Enter New Project");
        requiredCustomer.addProjectToCustomer(newProject);            
    }
    
    private void removeProjectFromCustomer() {
        InputHelper inputHelper = new InputHelper();
        boolean validCustomerId = false;
        Customer requiredCustomer=null;
        do {
            int customerId = inputHelper.readInt("Enter Customer Id");
            //requiredCustomer = repository.getItem(customerId);
            for (Customer customer:this.repository) {
                if (customer.getCustomerId() == customerId)
                    requiredCustomer = customer;
            }            
            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        int projectNumber = inputHelper.readInt("Enter Project Number", requiredCustomer.getNoCustomerProjects(), 1);   
        requiredCustomer.removeProjectFromCustomer(projectNumber);
    }
    
     public void store(String filename) {
        try (PrintWriter output = new PrintWriter(filename)) {
            for (Customer customer:this.repository) {
                output.print(customer.toString(DELIMITER));
            }
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }     
}
