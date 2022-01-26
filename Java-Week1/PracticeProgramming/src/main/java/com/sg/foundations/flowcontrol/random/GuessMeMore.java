/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose:
  * 
 */
package com.sg.foundations.flowcontrol.random;

import java.util.Random;
import java.util.Scanner;


public class GuessMeMore {
    
    public static void main(String[] args) {
      
        // initilising random class call it randomizer
        Random randomizer = new Random();
        
        // x - 100 where x is between 0 and 200, gives -100,100 boundary
        int num = randomizer.nextInt(200) - 100;

        System.out.println("Guess a number between -100,100: ");
        // gives the user 2 cahnces
        for (int i = 0; i < 2; i++) {
            
            // scanner to get input guess
            Scanner myScanner = new Scanner(System.in);
            int guess = Integer.parseInt(myScanner.nextLine());
               
            // if correct do this
            if (num == guess) {
                System.out.println("Well done your guess,"  + num+ ", was right!");
                break;
                
            }
            
            else {
                // else return there guess
                System.out.print("Your guess," + guess);
                
                // check if larger or smaller
                if (num < guess) {
                System.out.println(", was too big");
                }
                
                else if(num > guess){
                System.err.println(", was too small");
               
                }
                // if the first go, give them anotehr chance
            if (i == 0) {
                System.err.println("Try again: ");    
                }
            else {
                // else reveal answer
                System.err.println("Incorrect! The number was: " + num);
            }
    
                
            }
            
     
        }
  

    }
    
}
