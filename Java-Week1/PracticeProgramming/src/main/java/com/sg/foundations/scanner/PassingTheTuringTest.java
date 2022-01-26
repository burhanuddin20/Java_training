/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:20/07/2021
 * purpose: User variables to have convo with user
  * 
 */
package com.sg.foundations.scanner;

import java.util.Scanner;


public class PassingTheTuringTest {
    public static void main(String[] args) {
        
        // def all variables
        Scanner myScanner = new Scanner(System.in);
        String userName = "";
        String botName = "Atlas";
        
        String colour = "";
        String favFood = "";
        int num;
        
        System.out.println("Hi! What is you name?");
        // get user's name
        userName = myScanner.nextLine();
        System.out.println("Nice to meet you " + userName+ 
                " my name is " +botName+  ".");
        
        // get colour
        System.out.println("What is your favourite colour?");
        colour = myScanner.nextLine();
        
        System.out.println("Wow, "+colour+" is my favourite colour too.");
        // get fruit
        System.out.println("But what's your favourite fruit?");
        favFood = myScanner.nextLine();
        System.out.println("I don't really like " +favFood+" ,I prefer apples.");
         
        System.out.println("What's your lucky number?");
        // directly converting string to int and storing it 
        num = Integer.parseInt(myScanner.nextLine());
        System.out.println(num+"! Mine is 42.");
        System.out.println("Nice meeting you , bye!");
        
        
    }
    
}
