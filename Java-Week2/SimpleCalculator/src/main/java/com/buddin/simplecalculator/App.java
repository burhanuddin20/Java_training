/**
 *@author burhan
 *date: 27/07/2021
 * email: burhan.u6@hotmail.co.uk
 * purpose: Simple calculator with user interface
 */
package com.buddin.simplecalculator;

import java.util.Scanner;


public class App {
    
    public static void main(String[] args) {
      
         
         // calling methods from calculator class

         boolean calculate = true;
         do {   
             
             // instantiating a new calculator 
            SimpleCalculator calculator = new SimpleCalculator();
            
            
            // output the menu
            menu();
            
            Scanner userInput = new Scanner(System.in);
            
            System.out.println("\nChoose an option(number): ");
            
            int option = Integer.parseInt(userInput.nextLine());
            
             if (option == 5) {
                 System.out.println("Thank you for using the calculator");
                 calculate = false;
             }
             
             else{
            
                System.out.println("Enter the 1st number");
                double num1 = Double.parseDouble(userInput.nextLine());

                System.out.println("Enter the 2nd number");
                double num2 = Double.parseDouble(userInput.nextLine());
                System.out.println("\n");

                switch(option){

                    case 1:
                        System.out.println(calculator.add(num1, num2));
                        break;      
                    case 2:
                        System.out.println(calculator.subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println(calculator.multiply(num2, num2));
                        break;
                    case 4:
                        System.out.println(calculator.divide(num2, num2));
                        break;
                    
                }

                System.out.println("\nDo you want to try again?\n1.yes\n2.no ");
                int tryAgain = Integer.parseInt(userInput.nextLine());

                switch(tryAgain){
                        case 1:
                            break;
                        case 2:
                            calculate = false;

                        default:
                            break;
                    }
                }
                            
   
        } while (calculate);
         
    }
    
    public static void menu(){
    
        System.out.println("\n 1.Add \n 2.Subtract \n 3.Multiply \n 4.Divide "
                + "\n 5.Exit");
    
    }
    
 
    
    
    
    
}
