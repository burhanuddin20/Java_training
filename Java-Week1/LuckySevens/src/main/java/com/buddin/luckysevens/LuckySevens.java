/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 23/07/2021 
 * purpose:  
 */
package com.buddin.luckysevens;

import java.util.Random;
import java.util.Scanner;


public class LuckySevens {
    
    // keep rolling dice till money is finished
   
        
    // How many rolls were taken when max amount of money is won
    
   
    
    
    
    
    public static void main(String[] args) {
        
       // scanner to get user input 
       Scanner userInput = new Scanner(System.in);
    
       System.out.println("How much do you want bet? ");
       
       // save as inital bet
       double initBet = Double.parseDouble(userInput.nextLine());
       
        if (initBet == 0) {
            System.out.println("Have to bet money! Try again: ");
            initBet = Double.parseDouble(userInput.nextLine());
           
        }
       
       boolean gameOver = false ;
       
       // variables to track totals and rolls and their maxes
       double total = initBet;
       double maxTotal = 0;
       int rolls = 0;
       int maxRolls = 0;
       
        do {      
            // keep rolling die
            int num1 = simulator();
            int num2 = simulator();
            int sum = num1 + num2;
            
            
            // increment roll num by 1
            rolls ++;
            
            if(sum == 7){
                
                total += 4;
                
                if(total > maxTotal){
                
                 // if at the maximums save them;
                maxTotal = total;
                maxRolls = rolls;
                
                        
                }
            }
            else{
                    // decrease total by 1
                  total --; 
                    
                }
            
            if(total == 0){
                System.out.println("You are broke after " + rolls+" roll(s)");
                System.out.println("You should have quit after "
                        + maxRolls+" when you had $"+maxTotal+ ".");
                gameOver = true;
               
            }
            
  
            
        
        } while (!gameOver);// money not finished
       
        
    }
    

    public static int simulator(){
    // method to simulate dice roll
    
    
    Random roller = new Random();
    
    //(max - min + 1) + min
    // give a number between 1 to 6
    int num  = roller.nextInt(6)+1;
    
    return num;
     
    }
            

}
