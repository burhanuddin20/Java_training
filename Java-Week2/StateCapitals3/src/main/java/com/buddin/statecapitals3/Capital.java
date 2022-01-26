
package com.buddin.statecapitals3;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Capital {
    
    private String name;
    private int population;
    private double squareMileage;
    
    
    // constructor that saves all the properties
    public Capital(String name, int population, double squareMileage){
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    
    }
    
    
    public double getArea(){
    
        return squareMileage;
    }
    
    public int getPopulation(){
    
        return population;
    }
    
    public String getName(){
    
        return name;
    }

}
