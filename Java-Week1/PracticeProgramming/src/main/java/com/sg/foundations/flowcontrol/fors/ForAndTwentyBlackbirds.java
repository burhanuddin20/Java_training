/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:21/07/2021
 * purpose: Initiate a simple for loop
  * 
 */
package com.sg.foundations.flowcontrol.fors;


public class ForAndTwentyBlackbirds {
    public static void main(String[] args) {
        
        int birdsInPie = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
    
}
