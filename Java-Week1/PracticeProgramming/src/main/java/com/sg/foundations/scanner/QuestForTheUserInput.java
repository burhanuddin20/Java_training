/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:20/07/2021
 * purpose: Get basicc info using scanner
  * 
 */
package com.sg.foundations.scanner;

// links to core class w/ scanner
import java.util.Scanner;


public class QuestForTheUserInput {
    
    public static void main(String[] args){
        
        // create a scanner called inputReader using scanner class
        Scanner inputReader = new Scanner(System.in);
        
        // def 2 new strings
        String yourName,yourQuest;
        // one large float
        double velocityOfSwallow;
        
        // We can use the Scanner's readLine to assign value to our strings
        // because its return type is string
        // prompt user for name
        System.out.println("What is your name?? ");
        yourName = inputReader.nextLine();
        
        //find out the quest
        System.out.println("What is your quest?! ");
        yourQuest = inputReader.nextLine();// scanner to read next line
        
        /* When we get to our double data type,
        we can use Scanner's nextDouble method
         or we can use the Double.parseDouble to convert the nextLine's String
        */
        
        // propmt user for velocity
        System.out.println("What is the airspeed velocity of an "
                + "unladen swallow?!?! ");
        //parse the console input as a double and store in var
        velocityOfSwallow = Double.parseDouble(inputReader.nextLine());
        
        System.out.println();
        System.out.println("How do you know " + velocityOfSwallow + 
                " is correct, " + yourName + "?");
        System.out.println("You didn't even know if the swallow was"
                + " African or European!");
        System.out.println("Maybe skip answering things about birds and "
                + "instead go " + yourQuest + ".");
        //
    
    }
    
}
