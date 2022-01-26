/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date: 22/07/2021
 * purpose: Find the location of a certain value
 */
package com.sg.foundations.flowcontrol.arrays;
import java.util.Random;

public class HiddenNuts {
    
    public static void main(String[] args) {
        
        //1d string array length 100
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        
        // use random with the length as upper bound to get a num
        // that is the index where nut is hidden
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        
        System.out.println("The nut has been hidden ...");
        
        // nut finding 
        
        for(int i =0; i < hidingSpots.length; i++){
            
            if(hidingSpots[i] ==("Nut")){
                System.out.println("Found it! It;s in spot #" +i);
                break;
            }
            
        }
    
    }
  
}
