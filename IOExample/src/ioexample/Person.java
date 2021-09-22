/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexample;

/**
 *
 * @author ruslan
 */
public class Person {

    private String name;
    private int id;
    private int age;
    private double height;
    private double weight;

    public Person(String name, int id, int age, double height, double weight) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n"
                + "ID: " + this.id + "\n"
                + "Age: " + this.age + "\n"
                + "Height: " + this.height + "\n"
                + "Weight: " + this.weight + "\n";

    }
}
