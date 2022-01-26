
package com.buddin.enummath;

import com.buddin.enummath.IntMath.MathOperator;
import static com.buddin.enummath.IntMath.calculate;
import java.util.Scanner;

/**
 *
 * @author burhan
 * @date 13 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number 1");
        
        int num1 = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Enter number 2");

        int num2 = Integer.parseInt(scanner.nextLine());
        
        for (MathOperator operator : MathOperator.values()){
            
            int answer = calculate(operator,num1,num2);
            System.out.println(answer);
        

        } 
            
        
    }

    

}
