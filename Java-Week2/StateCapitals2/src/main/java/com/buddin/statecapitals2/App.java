
package com.buddin.statecapitals2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author burhan
 * @date 1 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {
    /*
    Hash map to hold states and their capitals
    StateCapitals.txt
    Load file and print out number of objects
    Then print all the state ma,es
    Choose a random state
    ask for the capital
    and return if they were right
    */
    public static void main(String[] args) throws Exception{
        
         // inititaise a new hash map
        Map<String,String> stateCapitals = new HashMap<>();
        
        Random randomizer = new Random();
        
        Scanner file = new Scanner(
            new BufferedReader(new FileReader("StateCapitals.txt")));
            while (file.hasNextLine()) {
                
                // saves the current line
                String currentLine = file.nextLine();
                // splits up the line where the Delimeter is
                String[] parts = currentLine.split("::");
                // save it to the hash map
                stateCapitals.put(parts[0], parts[1]);
            }
        //print out how many values where in file
        
        System.out.println("There are "+stateCapitals.size()+" "
                + "state/capitals pairs.\n");
        
        
        // print out all the state names
       Set<String> states = stateCapitals.keySet();
       
       for(String s : states){
       
           System.out.println(s);
       
       }
       
       // Random question
       // convert set to a list
       
       List <String> keys = new ArrayList<>(states); 
       
       // pick a random key i.e state
       String question = keys.get(randomizer.nextInt(states.size()));
       
       String answer = stateCapitals.get(question);
       
        System.out.println("\nWhat is the capital of "+question+ " state?");
        
        Scanner userInput = new Scanner(System.in);
        String userAnswer = userInput.nextLine();
        
        if (userAnswer.equals(answer)) {
            System.out.println("Correct!");
            
        }
        
        else{
            System.out.println("Incorrect! \nThe correct answer is "+answer);
        }
        
    }

}
