
package com.buddin.userio;

import java.util.Scanner;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class UserIOImpl implements UserIO{
    
    Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message); 
    }

    @Override
    public String readString(String prompt) {
        String input = userInput.nextLine();
        return (input);
   
    }

    @Override
    public int readInt(String prompt) {
       System.out.println(prompt);
       int num = Integer.parseInt(userInput.next());
       return num;
       
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
        boolean inputCorrect = false;
        int num;
        do  {
            System.out.println(prompt + min +"," + max);
            num = Integer.parseInt(userInput.next());
                
                if (num >= min && max>=num) {
                    inputCorrect = true;
                
            }
               
        } while (!inputCorrect);
 
        return num;
       
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double num = Double.parseDouble(userInput.next());
        return num;
        
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
        boolean inputCorrect = false;
        double num;
        do  { 
            System.out.println(prompt + min +"  " + max);
            num = Double.parseDouble(userInput.next());
                
                if (num >= min && max>=num) {
                    inputCorrect = true;
                
            }
               
        } while (!inputCorrect);
 
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float num = Float.parseFloat(userInput.next());
        return num;
        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        
        boolean inputCorrect = false;
        float num;
        do  { 
            
            System.out.println(prompt + min +"  " + max);
            num = Float.parseFloat(userInput.next());
                
                if (num >= min && max>=num) {
                    inputCorrect = true;
            }       
        } while (!inputCorrect);
        return num;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Long num = Long.parseLong(userInput.next());
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
       
        boolean inputCorrect = false;
        long num;
        do  { 
            System.out.println(prompt + min +"  " + max);
            num = Long.parseLong(userInput.next());
                
                if (num >= min && max>=num) {
                    inputCorrect = true;
            }       
        } while (!inputCorrect);
        return num;

    }
}
