
package com.buddin.statecapitals3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
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
public class StateCapitalsApp {
    
    public static void main(String[] args) throws Exception{
        
      
        
        
       
        
      
        // go through all pairs and use if statement
        // Do same thing for area
        
        // Hashmap that takes state an an object type Capital
        //state name is key capital object is value
         Map<String,Capital> stateCapitals = new HashMap<>();  
        
        
        // read the file in
        Scanner file = new Scanner(
            new BufferedReader(new FileReader("MoreStateCapitals.txt")));
            while (file.hasNextLine()) {

                // saves the current line
                String currentLine = file.nextLine();
                // splits up the line where the Delimeter is
                String[] parts = currentLine.split("::");
                
                
                // save it to the hash map
                // part 0 is the name
                // convert types for the numbers
                stateCapitals.put(parts[0],
                        new Capital(parts[1]
                                , Integer.parseInt(parts[2])
                                , Double.parseDouble(parts[3])));
            }
        
         // Print the number of state capitals
        System.out.println("There are "+stateCapitals.size()+" "
                + "state/capitals pairs.\n");
        
        // print State - |Capital| Pop: 12314 | Area: 156 sq mi
        
        // save all the state names
        Set<String> states = stateCapitals.keySet();
        
       // print each field of capital object to the screen
        for (String s : states) {
            
            // store the value for that key as object called info
            Capital info = stateCapitals.get(s);
            
            String name = info.getName();
            int population = info.getPopulation();
            double area = info.getArea();
            System.out.println(s+" - | " + name+" |Pop: "+ population+" | Area: "
                    + area+" sq mi");
            
        }
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the lower population limit?");
        int popLimit = Integer.parseInt(userInput.nextLine());
        
        
        System.out.println("These states have a population greater than "+popLimit);
        for (String s : states) {
            
            Capital info = stateCapitals.get(s);
            String name = info.getName();
            int population = info.getPopulation();
            double area = info.getArea();
            
            if(population > popLimit){
            System.out.println(s+" - | " + name+" |Pop: "+ population+" | Area: "
                    + area+" sq mi");
            
            
            }
        }
            
             System.out.println("What is the upper area  limit?");
            int areaLimit = Integer.parseInt(userInput.nextLine());
            
        System.out.println("These states have an area greater than "+areaLimit);
        for (String s : states) {
            
            Capital info = stateCapitals.get(s);
            String name = info.getName();
            int population = info.getPopulation();
            double area = info.getArea();
            
            if(area < areaLimit){
            System.out.println(s+" - | " + name+" |Pop: "+ population+" | Area: "
                    + area+" sq mi");
            
            
            }
        }    

        
    }

}
