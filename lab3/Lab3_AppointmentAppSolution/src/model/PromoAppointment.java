/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author mga
 */
public class PromoAppointment  extends Appointment implements Serializable {
    private String promoCode;
    private int discountPercentage;
    
    public PromoAppointment() {
        super();
        this.promoCode = null;
        this.discountPercentage = 0;
    }
    
    public PromoAppointment(String customerName, LocalTime appointmentTime, int appointmentLength, String promoCode, int discountPercentage) {
        super(customerName, appointmentTime, appointmentLength);
        this.promoCode = promoCode;
        this.discountPercentage = discountPercentage;
    }
 
    public String getPromoCode() {
        return this.promoCode;
    }
    
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
    
    public int getDiscountPercentage() {
        return this.discountPercentage;
    }
    
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }   
    
    @Override
    public String toString() {
        return super.toString() +
                "Code: " + this.promoCode + 
                " Discount: " + Integer.toString(this.discountPercentage) + "\n";                
    }
    
    @Override
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = QUOTE + this.customerName + QUOTE + delimiter +
                QUOTE + this.appointmentTime + QUOTE + delimiter +  
                Integer.toString(this.appointmentLength) + delimiter +
                QUOTE + this.promoCode + QUOTE + delimiter +  
                Integer.toString(this.discountPercentage) + EOLN;
        return str;
    }    
}
