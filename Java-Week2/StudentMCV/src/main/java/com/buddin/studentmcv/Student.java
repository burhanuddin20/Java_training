/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 28/07/2021 
 * purpose: Class defines all the properties of the student and getters/setters
 */
package com.buddin.studentmcv;


public class Student {
    
    // define name and roll num fields
    private String name;
    private int rollNum;
    
    // getter for name
    public String getName(){
        return name;
    }
    
    //setter for name
    public void setName(String name){
        
        this.name = name;
    }
    
    // getter for roll       num 
     public int getRollNum(){
        return rollNum;
    }
    
    //setter for roll num
    public void setRollNum(int rollNum){
        this.rollNum  = rollNum;
        this.name = name;
    }
    
}
