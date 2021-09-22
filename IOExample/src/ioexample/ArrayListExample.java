/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexample;

import java.util.ArrayList;

/**
 *
 * @author ruslan
 */
public class ArrayListExample {
    
    
    // Demonstrates the creation of Person instances
    // And adding/removing those instances to an ArrayList
    public static void main(String [] args)
    {
        ArrayList<Person> persons = new ArrayList<>();
        
        
        Person person1 = new Person("Ruslan",001,20,171,150);
        Person person2 = new Person("Masinjila",011,99,200,50);
        Person person3 = new Person("Fred",211,12,111,72);
        
        System.out.println("Array list before adding persons:\n"+persons.toString());
        System.out.println("=======================================================");
        
        persons.add(person1);
        System.out.println("Array list after adding person1:\n"+persons.toString());
        System.out.println("=======================================================");
        
        persons.add(person2);
        System.out.println("Array list after adding person2:\n"+persons.toString());
        System.out.println("=======================================================");
        
        persons.add(person3);
        System.out.println("Array list after adding person3:\n"+persons.toString());
        System.out.println("=======================================================");
        
        persons.remove(person1);
        System.out.println("Array list after removing person1:\n"+persons.toString());
        System.out.println("=======================================================");
        
        persons.remove(person2);
        System.out.println("Array list after removing person2:\n"+persons.toString());

        
    }
    
}
