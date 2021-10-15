/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import controllers.CustomerProjectsController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import repositories.Repository;

/**
 *
 * @author ruslan
 */
public class DAOObjectImpl implements DAOInterface {

    public Repository load(String filename) {

        Repository repository = new Repository();

        try {
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {

                ArrayList<Customer> customers;
                customers = (ArrayList<Customer>) ois.readObject();

                for (Customer temp : customers) {
                    repository.add(temp);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(0);
        }

        return repository;

    }

    public void store(String filename, Repository repository) {

        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(repository.getItems());
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerProjectsController.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerProjectsController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }

    }

}
