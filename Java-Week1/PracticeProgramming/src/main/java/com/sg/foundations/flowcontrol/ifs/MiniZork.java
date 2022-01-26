/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose: Create an interactive story using if/else statements
  * 
 */
package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class MiniZork {
    
    public static void main(String[] args) {

        // initialising the scanner
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.println("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You put your hand in...");
                System.out.println("You activate tnt...");
            
            }
        } else if (action.equals("house")) { 
            System.out.println("You arrive at the house.");
            System.out.println("The door is boarded up");
            System.out.println("You notice a shed behind the house ");
            System.out.println("Go the shed or knock on the door? ");
            
            //get their input
            action = userInput.nextLine();
            
            if (action.equals("shed")) {
                System.out.println("You walk to the shed...");
                System.out.println("You hear rustilng inside the shed");
                System.out.println("A bear breaks through the door! ");
                System.out.println("Bear eats you! ");
            }
            
            else if (action.equals("knock")){
                System.out.println("Knock! Knock! Knock!");
                System.out.println("Someone yells, you can hear footsteps.");
                System.out.println("Your mum opens the door.");
                System.out.println("She asks do you want to go the store or "
                        + "stay home?");
            
            }
                    
        
        
        }

        
    }
}