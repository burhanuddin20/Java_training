/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 26/07/2021 
 * purpose:  Refactorize the original factorizer program
 */
package com.buddin.refactoring;

import java.util.Arrays;
import java.util.Scanner;

// class factorizes and returns result as an array
public class Factorizer{
    
public void factorize(){
     // get num for user
        // print that num
        
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = Integer.parseInt(myScanner.nextLine());
        
        
        
        
        System.out.println("Factors of " + num + " are:");
        // find factors and store them
        
        // create an array called factors with length of 1
        int [] factors = new int[1];   
      
       int j =0;
       int sum = 0;
       
       // for loop up to the value entered
        for(int i = 1; i < num; i++){
            
            
            //special case for the number 1
            if(i == 1){
                System.out.print(i); 
                factors[j] = i;
                sum += i;
                j++;
                
            }
                
                // if i  a factor and not the current number
            else if (i != num && num% i == 0) {
                // Output that num
                System.out.print(" " + i); 
                factors = AppendArray(factors);// create room for the factor
                factors[j] = i; // store the factor
                sum += i;
                j++;

                }
            
            
        }
     
        
        System.out.println("\n");
        // output how many factors there is 
        System.out.println(num + " has " + factors.length+ " factors.");
       
       
        if (sum == num) {
            System.out.println(num +" is a perfect number.");
  
        }
        else{
            
            System.out.println(num +" is not a perfect number.");
        
        }
        
        if (factors[factors.length -1] == 1) {
            
            System.out.println(num +" is a prime number.");
            

        }
        
        else{
            
             System.out.println(num +" is not a prime number.");

        }
        



}
    


    
    
    
    
public static int[] AppendArray(int[] original)
{   
    int[] newArray = new int[original.length + 1];

    for (int i = 0; i < original.length; i++)
    {
        // copy the element at the current index
        // from original to newArray
        newArray[i] = original[i];
    }

    return newArray;
}
    
}





