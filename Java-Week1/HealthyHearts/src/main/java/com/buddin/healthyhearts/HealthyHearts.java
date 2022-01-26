/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 23/07/2021 
 * purpose:  Program to calculate healthy and max heart rate from given age
 */



package com.buddin.healthyhearts;

import java.util.Scanner;


public class HealthyHearts {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        // get user age
        System.out.println("What is your age? ");
        // calculate their maximum heart rate
        double maximumRate = 220 - Integer.parseInt(userInput.nextLine());
        
        // round the numbers and store as whole numbers
        // Have to use double
        double lowerBound = Math.round(0.5 * maximumRate);
        double upperBound = Math.round(0.85 * maximumRate);
        // print max hear rate
        //cast as int because bpm has to be whole number
        System.out.println("Your maximum heart rate should be "
                + (int)maximumRate+" beats per minute");
        
        // print healthy range
        System.out.println("Your target HR Zone is  "
                + (int)lowerBound+" - " + (int)upperBound+  " beats per minute");
        

    }
    
   
    
}
