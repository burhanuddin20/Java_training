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
import java.math.RoundingMode;

// fix decimal issue
// make cleaner

public class InterestCalculator {
    
    public static void init(BigDecimal initPrincipal,int timePeriod, BigDecimal apr){
    
   
    BigDecimal balance = initPrincipal;
    BigDecimal earned;
    
    System.out.println("\n");
    
        for (int i = 1; i < timePeriod + 1; i++) {
            System.out.println("Year " + i);
            System.out.println("Beginning balance $" + balance);
            
            BigDecimal [] values =  calculator(balance, apr);
            earned = values[1];
            earned.setScale(2, RoundingMode.HALF_UP);
            balance = values[0];
            balance.setScale(2, RoundingMode.HALF_UP);
            System.out.println("Earned $" + earned.toString()); 

            System.out.println("Closing balance $" + balance.toString() +" \n"); 
 
        }
        
    
    }
    
    
    // method to compound take interest rate and balance as inputs
    // returns balance and earned
    public static BigDecimal [] calculator(BigDecimal x , BigDecimal apr){
        
        BigDecimal balance = x;
        BigDecimal earned = new BigDecimal("0.00") ;
        BigDecimal totalEarned = new BigDecimal("0.00");
        
        totalEarned.setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal quarter = new BigDecimal("400");
        BigDecimal one = new BigDecimal("1");
        
        // need to run this 4 times
        // divide by 4 to get quaterly
        for(int i = 0; i < 4 ; i++){
            // compound 
            
            BigDecimal aprAsDecimal = (apr.divide(quarter)).add(one);
            balance  = balance.setScale(2, RoundingMode.HALF_UP);
            earned = balance.multiply(aprAsDecimal);
            earned = earned.subtract(balance);
            earned = earned.setScale(2, RoundingMode.HALF_UP);
            totalEarned = totalEarned.add(earned);
            //System.out.println("earned:" + earned);
            // update balance
            balance = balance.add(earned);
       
            //System.out.println("balance:" + balance);
        }
        
        BigDecimal earnings =  balance.subtract(x);
     
        BigDecimal [] values = {balance,earnings};
        
        
    return values;
    }
    
}
