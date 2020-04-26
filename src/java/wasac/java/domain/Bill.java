/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wasac.java.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Henriette
 */
@Entity
public class Bill{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String meter_owner;
    private int start_numbers;
    private int end_numbers;
    private String category;
    private double amount;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeter_owner() {
        return meter_owner;
    }

    public void setMeter_owner(String meter_owner) {
        this.meter_owner = meter_owner;
    }

    
    public int getStart_numbers() {
        return start_numbers;
    }

    public void setStart_numbers(int start_numbers) {
        this.start_numbers = start_numbers;
    }

    public int getEnd_numbers() {
        return end_numbers;
    }

    public void setEnd_numbers(int end_numbers) {
        this.end_numbers = end_numbers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bill(int id, int start_numbers, int end_numbers, String category, double amount) {
        this.id = id;
        this.start_numbers = start_numbers;
        this.end_numbers = end_numbers;
        this.category = category;
        this.amount = amount;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return category ;
    }
    
    
}
