/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose: fizz buzz exercise in Java
  * 
 */
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;


public class TraditionalFizzBuzz {
    public static void main(String[] args) {
      
        Scanner myScanner = new Scanner(System.in);
        // Upper bound or the number to count to 

        
        System.out.println("How many fizzbuzzes?: ");
        // Use scanner to get the boun
        int bound = Integer.parseInt(myScanner.nextLine());
        System.err.println("\n");
        
        // for loop from zero inclusive of the bound
        // print zero outside
        System.out.println("0");
        for(int i =1; i < bound+1; i++ ){
  
            // check fizz buzz case
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
            }
            // check buzz
            else if (i % 5 == 0) {
                System.out.println("buzz");
                
            }
            // check fizz
             else if (i % 3 == 0) {
                System.out.println("fizz");
                
            }
            // if none are divisible just print the number
             else{
                 System.out.println(i);
             }
            
        }
        
    }
    
}
