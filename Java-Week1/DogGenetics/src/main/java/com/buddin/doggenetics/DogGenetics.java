/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 23/07/2021 
 * purpose:  Program to simulate dog breeds
 */

package com.buddin.doggenetics;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author burhan
 */
public class DogGenetics {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is the name of your dog? ");
        
        // get name of dog
        String name = userInput.nextLine();
        
        // Array of dog breeds
        String[] dogBreeds = {"Pitbull", "Dane","German Shepard","Chihuahua",
            "Terrier"};
        
        Random randomizer = new Random();
        
        // variable for total percentage
        int total = 0;
        // variable to eliminate choices as they are chosen
        int x = 0;
        // output message
        System.out.println(name+ " is these breeds: ");
        // main loop
        while(total != 100){
        
        // choose a number that corresponds to breed
        int breed = randomizer.nextInt(5-x); // pick a number between 0 and 5
        x++; // decrease the number of options by 1
        
      
        int percentage = randomizer.nextInt(100-total) + 1;// pick % up to 100
        
            if (dogBreeds.length == 1) {
                percentage = 100 - total;
                
            }
        
        //output the info
        System.out.println(percentage+"% " + dogBreeds[breed]);
        
        
        total+=percentage;// increase total
            if (total == 100) {
                break;
            }
            
        dogBreeds = remover(dogBreeds, breed, x); //remove the breed from the list
        }
        
        
      

    }
    // list of breeds, index to be removed and array decrease size
    public static String[] remover(String[] a, int b,int x) {
        
        int breedIndex = b;
        String[] breed = a;
        String temp[] = new String[5-x];
        
        for (int i = 0, j = 0; i < breed.length; i++) {
            // if we are on the breed that has alraedy been chosen
            // remove from list
            if (i == breedIndex) {
                continue;
                
            }
            else{
            // save it to new list
                
            temp[j++] = breed[i];
            }
        }
              
        
        return temp;
         
    }
    
}
    