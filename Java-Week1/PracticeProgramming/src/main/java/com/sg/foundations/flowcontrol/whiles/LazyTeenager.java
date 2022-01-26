/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose:Print a statement till condition is met
  * 
 */
package com.sg.foundations.flowcontrol.whiles;
import java.util.Random;

public class LazyTeenager {
    
    public static void main(String[] args) {
        
        Random randomizer = new Random();

        boolean clean = false;
        int chance = 0;
        // generate a random probability 
        int totalChances = randomizer.nextInt(10);
        
             
        
        do{
            // print the statement 
            // increase chance of cleaning by 10%
            System.out.println("Clean your room!!");
            chance ++;           
           
            // if 7 attempts have happened 
            // break and punish
            if (chance == 7){
                System.out.println("Clean your room!!");
                System.out.println("Im taking your XBOX");
                break;
            
            }
            
            // else check if probabilities match
            else if (chance == totalChances) {
                System.out.println("Ok I will!");
                clean = true;
                
            }
        }while (!clean); 

        
        
        
        
    }
    
}
