/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdHocProject;
import model.Customer;
import model.PlannedProject;
import model.Project;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class DAOTextImpl implements DAOInterface {
    
    static final char DELIMITER=',';   

    @Override
    public Repository load(String filename) {
        
        Repository repository = new Repository();

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
                    line = br.readLine();
                    temp=line.split(Character.toString(DELIMITER)); 
                    String projectId = stripQuotes(temp[0]);
                    String projectTitle = stripQuotes(temp[1]);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDateStr = stripQuotes(temp[2]);
                    Date startDateDate;
                    Calendar startDate = null;
                    try {
                        startDateDate = dateFormat.parse(startDateStr);
                        startDate = Calendar.getInstance();
                        startDate.setTime(startDateDate);                
                    } catch (ParseException ex) {
                        Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    char projectType = temp[3].charAt(1);
                    if (projectType == 'P') {
                        Set<String> projectEmployees = new HashSet<>();
                        for (int j=4; j<temp.length-1; j++) {
                            String employee = stripQuotes(temp[j]);
                            projectEmployees.add(employee);
                        }
                        int noAllocatedDays = Integer.parseInt(temp[temp.length-1]);
                        Project project = new PlannedProject(projectId, projectTitle, startDate, projectEmployees, noAllocatedDays);
                        customer.addProjectToCustomer(project);
                    }
                    else if (projectType == 'A') {
                        String employee = stripQuotes(temp[4]);
                        Project project = new AdHocProject(projectId, projectTitle, startDate, employee);
                        customer.addProjectToCustomer(project);
                    }
                }
                repository.add(customer);                
                line = br.readLine();                
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
    }
    
    @Override
    public void store(String filename, Repository repository) {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
