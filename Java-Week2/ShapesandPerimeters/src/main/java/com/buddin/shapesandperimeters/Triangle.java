 
package com.buddin.shapesandperimeters;
import java.lang.Math;
/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Triangle extends Shape{
    
    private double a;
    private double b ;
    private double c;
    protected double area;
    protected double perimeter;
    
    public  Triangle(double a, double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    
    
    @Override
    public double getArea() {
        double inDegrees = Math.toDegrees(Math.sin(c));
        return a*b*Math.sin(inDegrees);
        
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
        
    }

}
