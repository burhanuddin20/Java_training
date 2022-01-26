package com.buddin.interestcalculator;

import static com.buddin.interestcalculator.InterestCalculator.init;
import java.math.BigDecimal;
import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        
        
         // create the scanner to get the input
    Scanner userInput = new Scanner(System.in);
    
    // get initial principal
    System.out.println("How much do you want to invest: ");
    BigDecimal initPrincipal =  new BigDecimal(userInput.nextLine());
    System.out.println("How many years do you want to invest: ");
    int timePeriod = Integer.parseInt(userInput.nextLine());
    
    System.out.println("What is the interest rate %: ");
    // get apr
    BigDecimal apr = new BigDecimal(userInput.nextLine());


    init(initPrincipal,timePeriod,apr);

    }
}
