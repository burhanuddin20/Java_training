
package com.buddin.shapesandperimeters;
import  java.lang.Math;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Circle extends Shape{
    
    private double radius;
    private final double pi;
    
    
    public Circle(double radius, double pi){
        this.radius = radius;
        this.pi = Math.PI;
        
    }
    
    
    @Override
    protected double getArea() {
        return pi*radius*radius;
        
    }

    @Override
    protected double getPerimeter() {
        return 2*pi*radius;
        
    }

    

}
