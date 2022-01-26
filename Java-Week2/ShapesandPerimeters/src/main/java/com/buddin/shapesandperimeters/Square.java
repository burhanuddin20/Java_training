
package com.buddin.shapesandperimeters;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Square extends Shape{
    
   double length1;
   
   public Square(double length1){
   
   this.length1 = length1;  
   }

    @Override
    public double getArea(){
       return length1 * length1;
    
    }

    @Override
    public double getPerimeter() {
        return 4*length1;
        
    }
    
    
    
}
