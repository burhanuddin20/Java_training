
package com.buddin.shapesandperimeters;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Test {
    
    
    public static void main(String[] args) {
        
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.getArea();
        triangle.perimeter = triangle.getPerimeter();
        System.out.print(triangle.perimeter);
        triangle.area =triangle.getArea();
        System.out.print("\n"+  triangle.getArea());
    }

}
