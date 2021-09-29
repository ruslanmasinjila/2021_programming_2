/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public enum EmployeeRoleType {
    
    PROJECTLEADER ('A',6),
    ANALYST ('B', 3),
    DEVELOPER ('B', 3),
    TESTER ('C', 1);
    
    private final char salaryGrade;
    private final int noticePeriod;
    
    EmployeeRoleType(char salaryGrade, int noticePeriod) {
        this.salaryGrade = salaryGrade;
        this.noticePeriod = noticePeriod;
    }
    
    private char getSalaryGrade() {
        return this.salaryGrade;
    }
    
    private int getNoticePeriod() {
        return this.noticePeriod;
    }
    
    @Override
    public String toString() {
        return name() + " (Salary Grade: " + getSalaryGrade() + ", Notice Period: " + getNoticePeriod() + " months)";
    }
}
