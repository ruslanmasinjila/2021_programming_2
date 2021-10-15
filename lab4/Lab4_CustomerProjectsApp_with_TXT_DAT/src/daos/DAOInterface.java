/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import repositories.Repository;

/**
 *
 * @author ruslan
 */
public interface DAOInterface {
    
    public Repository load(String filename);
    public void store(String filename, Repository repository);
}
