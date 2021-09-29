/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author mga
 */
public class Repository {
    private List<Customer> items;    
    static char DELIMITER=',';
    
    public Repository() {
        this.items = new ArrayList<>();
        //this.items = new LinkedList<>();        
    }
    
    public Repository(List<Customer> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        // Insert load code from controller

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
                this.items.add(customer);                
                line = br.readLine();                
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Replace with dao creation & call
         
    }
    
    public List<Customer> getItems() {        
        return this.items;
    }
    
    public void setItems(List<Customer> items) {        
        this.items = items;
    }
    
    public void add(Customer item) {
        this.items.add(item);
    }
       
    public void remove(int id) {
        Predicate<Customer> customerPredicate = c->c.getCustomerId() == id;       
        this.items.removeIf(customerPredicate);
    }
    
    public Customer getItem(int id) {
        for (Customer item:this.items) {
            if (item.getCustomerId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nCustomers: " + this.items;
    }
    
    public String toString(char delimiter) {
        String output = "";
        for (Customer item: this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }
    
    public void store(String filename) {
        // Insert store code from controller
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(this.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }         
        // Replace with dao creation & call
    }    
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }     
}
