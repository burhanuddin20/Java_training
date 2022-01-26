
package com.buddin.shapesandperimeters;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */

public class Rectangle extends Shape{
    
    private double length1;
    private double length2;
    
    public Rectangle(double length1, double length2){
    
    this.length1 = length1;
    this.length2 = length2;
    }

    @Override
    public double getArea() {
        return length1 * length2;
        
    }

    @Override
    public double getPerimeter() {
        return 2*(length1 + length2);
    }

}
