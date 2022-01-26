/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:22/07/2021
 * purpose: Use methods to randomly create data
  * 
 */
package com.sg.foundations.flowcontrol.methods;

import java.util.Random;


public class BarelyControlledChaos {
    
    
    public static void main(String[] args) {
        
          
        // feed a string of arrays into the methods and save them
        String color = randString( new String []{"yellow","red","blue","green"}); 
        String animal = randString( new String []{"cat","dog","wolf"}); 
        String colorAgain = randString( new String []{"yellow","red","blue",
            "green"}); 
        
        
        
        int weight = randNum(5, 200); // call number method,
            // with a range between 5 - 200
        int distance = randNum(10, 20); // call number method,
            // with a range between 10 - 20
        int number = randNum(10000, 20000); // call number method,
            // with a range between 10000 - 20000
        int time = randNum(2, 6); // call number method,
            // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }
    
    
   // uses the random function to choose a random index
    public static String randString(String [] list){
        int x = randNum(0, list.length-1);
        
        return list[x];
        
    }

    

     // generates all the needed random numbers
    public static int randNum(int a, int b){
        
        Random randomizer = new Random();
        // method to return a random num between a,b
       int num = randomizer.nextInt(b-a)+a;
       return num;
    
    }
    
}
