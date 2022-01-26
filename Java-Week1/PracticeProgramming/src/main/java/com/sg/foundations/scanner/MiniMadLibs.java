/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:20/07/2021
 * purpose:Get input from user and replace words in string
  * 
 */
package com.sg.foundations.scanner;
// class w/ scanner
import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        
        //initialising scanner
        Scanner myScanner = new Scanner(System.in);
        
        //getting first noun
        System.out.println("Enter a noun: ");
        String noun1 = myScanner.nextLine();
        
        System.out.println("Enter an adjective: ");
        String adjective1 = myScanner.nextLine();
        
        System.out.println("Enter another noun: ");
        String noun2 = myScanner.nextLine();
       
        // get an int from the user
        System.out.println("Enter a whole number: ");
        String stringnum = myScanner.nextLine();
        
        int num = Integer.parseInt(stringnum);
        
        System.out.println("Enter another adjective: ");
        String adjective2 = myScanner.nextLine();
        // getting all plural nounes in one go
        System.out.println("Enter 3 plural nouns: ");
        String pNoun1 = myScanner.nextLine();
        String pNoun2 = myScanner.nextLine();
        String pNoun3 = myScanner.nextLine();
        
        System.out.println("Enter a present tense verb: ");
        String presVerb = myScanner.nextLine();
        
        System.out.println("Enter the past tense version: ");
        String pastVerb = myScanner.nextLine();
        
        //outputting the entire text.
        System.out.println(noun1 + ": the " + adjective1 + "frontier. "
                + "These are the voyages of the starship " + noun2 + "."
                + " Its " + num + "-year mission: to explore strange "
                        + adjective2 + pNoun1 + ", to seek "
                + "out " + adjective2+ pNoun2 + " and " + adjective2 + pNoun3+ 
                ", to boldly "+ presVerb + "where no one has " + pastVerb+ "before.");
        
    }
}
