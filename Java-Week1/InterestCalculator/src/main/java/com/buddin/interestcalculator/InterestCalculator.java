/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:23/07/2021
 * purpose: Create an interest calculator
  * 
 */
package com.buddin.interestcalculator;

import java.util.Scanner;
import java.math.BigDecimal;

// fix decimal issue
// make cleaner

public class InterestCalculator {
    
    public static void main(String[] args){
    
    // create the scanner to get the input
    Scanner userInput = new Scanner(System.in);
    
    // get initial principal
    System.out.println("How much do you want to invest: ");
    
    double initPrincipal = Double.parseDouble(userInput.nextLine());
    
    // get time period
    System.out.println("How many years do you want to invest: ");
    
    int timePeriod = Integer.parseInt(userInput.nextLine());
    
    // interest rate
    System.out.println("What is the interest rate %: ");
    
    double interestRate = (Double.parseDouble(userInput.nextLine())*100)/100.00;
    
    double balance = (initPrincipal * 100)/100.00;
    double earned;
    System.out.println("\n");
        for (int i = 1; i < timePeriod + 1; i++) {
            System.out.println("Year " + i);
            System.out.println("Beginning balance $" + balance);
            
            double [] values =  calculator(balance, interestRate);
            earned = values[1];
            balance = values[0];
          
            System.out.println("Earned $" + earned); 
            
            
            System.out.println("Closing balance $" + balance +" \n"); 
 
        }
        
    
    }
    
    
    // method to compound take interest rate and balance as inputs
    // returns balance and earned
    public static double [] calculator(double x , double apr){
    
        double balance = x;
        double earned = 0.00 ;
        double totalEarnings = 0.00;
        
        // need to run this 4 times
        // divide by 4 to get quaterly
        for(int i = 0; i < 4 ; i++){
            // compound 
            earned = balance * (1 + (apr/ 400)) - balance;
            totalEarnings += earned;
            //System.out.println("earned:" + earned);
            // update balance
            balance += earned;
            //System.out.println("balance:" + balance);
        }
        double earnings = balance - x;
     
        double [] values = {balance,earnings};
        
        
    return values;
    }
    
}
