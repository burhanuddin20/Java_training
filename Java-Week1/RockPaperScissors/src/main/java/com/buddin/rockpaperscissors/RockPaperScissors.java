/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 23/07/2021 
 * purpose:  Program to simulate rock,paper, scissors
 */
package com.buddin.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;



public class RockPaperScissors {
    
    public static void main(String[] args){
        
        // set up random and scanner
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        // game boolean
        boolean game = true;
        // start of do while loop
        do {            
            
        // find out how many rounds
        System.out.println("How many rounds do you want to play? ");
        int rounds = Integer.parseInt(userInput.nextLine());
      
        // if outside of range, end program
        if ( 0 >= rounds || rounds > 10) {
            
            System.out.println("Error! Range has to be 1-10!");
            System.exit(0);    
        } 
        
        // array of the options
        String[] choice =  {"Rock","Paper","Scissors"};
        
        // count for each scenario
        int userWins = 0;
        int compWins = 0;
        int ties = 0;
        
        // main loop that runs the rock paper scissors
        for(int i = 0; i < rounds; i++){
            
            // ask user for their choice
            System.out.println("Rock, paper or scissors? \n Rock = 1, Paper = 2"
                    + "and Scissors = 3");
            
            int[] play = new int[2];
            
            // variable that stores there choice - 1 so it matches the index
            play[0] = Integer.parseInt(userInput.nextLine()) -1;
            
            //Gives a number between 0,2 which matches the index
            play[1] = randomizer.nextInt(3);
            
            //play[cpu,user]
            System.out.println("user: "+ choice[play[0]] + " ,computer: "+ 
                    choice[play[1]]);
            
            // 0 = draw , 1 = cpu win, 2 = human win
            // first option is cpu and then human input
            int result = decider(play[1], play[0]);
            
            // different cases from the decider
            switch(result){
                // if decider was a tie
                case 0:
                    ties++;
                    System.out.println("tie");
                    break;
                case 1: // if cpu won 
                    compWins++;
                    System.out.println("cpu win");
                    break;
                case 2:
                    userWins++; // if user won
                    System.out.println("user win");
                    break;
            }
   
        }
        
        System.out.println("There was " +ties+ " ties, the computer won " +
                compWins+" and the user won " +userWins+" .");
        
        // select overall winner
        if (userWins > compWins) {
             System.out.println("The user wins.");
            
        }
        else if (compWins > userWins) {
             System.out.println("The computer wins.");
            
        }
        
        else if (compWins == userWins) {
             System.out.println("Overall tie.");
            
        }
            
        // does user want to play again
           System.out.println("Do you want to play again?,yes or no");   
           String rerun = userInput.nextLine();
           
            switch (rerun) {
                case "no":// end game
                    game = false;
                    break;
                case "yes":// continue
                    game = true;
                    break;
                default:// any other input exit
                    game = false;
                    break;
            }
            
    } while (game);
    
    }
    
    
    // method to decide winner
    public static int decider(int a, int b){
        
        // saving the cpu choice, user input and result
        int cpuChoice = a;
        int human = b;
        int result = 0 ;
        // if cpu chooses rock
        if( cpuChoice == 0){
            
            switch(human){
                // if user chose rock
                case 0:
                    result = 0;
                    break;// tie
                  
                // user chose paper
                case 1:
                    result = 2;
                    break;// user won
                
                // user chose scissor
                    
                case 2:
                    result = 1;
                    break;// cpu won
    
            }
     
        } 
        // cpu chose paper
        else if (cpuChoice == 1) {
            
             switch(human){
                // if user chose rock
                case 0:
                    result = 1;
                    break;// cpu win
                  
                // user chose paper
                case 1:
                    result = 0;
                    break;// tie
                    
                // user chose scissor
                case 2:
                    result = 2;
                    break;// human win
    
            }

        }
         
        // cpu chose scissors
         else if (cpuChoice == 2) {
            
             switch(human){
                 
                // if user chose rock
                case 0:
                    result = 2;
                    break;// user win
                  
                // user chose paper
                case 1:
                    result = 1;
                    break;// cpu win
                    
                // user chose scissor
                case 2:
                    result = 0;
                    break;// ties
            } 
        }
        // return the int representing each case
    return result;
        
    }
    
}
