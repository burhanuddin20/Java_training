/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 26/07/2021 
 * purpose:  Model a car as if the class were to be part of an inventory system for a car dealership.
 */
package com.mycompany.classmodeling;


public class CarDealership {
    
    private String brand;
    private String model;
    private int yearOfManufacture;
    private String colour;
    private int inventory;
    
    // want the code to set the brand model and year
    
    // constructor to store this information as a new object
    public CarDealership(String brand, String model, int yearOfManufacture, String colour) {
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.colour = colour;
    }
    
    // behaviours 
    // return the stock
    
    // set the stock for a potential car
    public void setStock(int x){
         this.inventory = x;
    }
    
    // return the stock for a car
    public int getStock(){
        return inventory;
    }

}
