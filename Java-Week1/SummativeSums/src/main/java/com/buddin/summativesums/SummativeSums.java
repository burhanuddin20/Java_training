/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 23/07/2021 
 * purpose:  Program to calculate sum of an array given an array of arrays
 */
package com.buddin.summativesums;

import java.util.Arrays;


public class SummativeSums {
    
    public static void main(String[] args) {
        
        // arrays to add up        
        int[] arr1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] arr2 = { 999, -60, -77, 14, 160, 301 };
        int[] arr3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        int[][] finalArr = {arr1,arr2,arr3};
        
        // for the length of the array
        for (int i = 0; i < finalArr.length; i++) {
            
            // sum each individual array
            int result = summer(finalArr[i]);
            
            // output the array
            System.out.println("#" +(i+1)+" Array Sum: "+ result);
        }
    }
       

    
    public static int summer(int[] a){
        
        int sum = 0;
        
        // add each individual element
        for (int j = 0; j < a.length; j++) {
            sum += a[j];
        }
        return sum;
    
    
    }
    
}
