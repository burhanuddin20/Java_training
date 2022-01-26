/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose: Practice how while loop conditions work
  * 
 */
package com.sg.foundations.flowcontrol.whiles;


public class WaitAWhile {
    
    public static void main(String[] args){
    
        int timeNow = 5;
        int bedTime = 10;
        
        while (timeNow < bedTime) {
            
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a"
                     + " liiiiittle longer....");
             
            timeNow++; // Time passes
        }
        System.out.println("Oh. It's " + timeNow + " o'clock. ");
        System.out.println("Guess I should go to bed ...");    
    }
    //q1. While loop is never valid therefore last statemetns are printed
    //q2. infinite loop as long as time now is less than bedtime
    
        
    
}
