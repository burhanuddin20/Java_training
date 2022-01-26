/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:20/07/2021
 * purpose: Create a menu with ascii art
  * 
 */


package com.sg.foundations.variables;

public class MenuOfChampions{

    public static void main(String[] args) {
        //restuarant name
        String name = "Soho";
        
        //define 3 dishes and prices
        
        String dish1 = "Salmon steak";
        String dish2 = "Tuna roll";
        String dish3 = "Beef dumpling";
        
        double price1 = 23.00;
        double price2 = 8.99;
        double price3 = 13.99;
        
        //Output the menu
        
        System.out.println("Hi welcome to " + name+ "today's menu:");
        
        System.out.println("£" +price1+ "  " + dish1);
        System.out.println("£" +price2+ "  " + dish2);
        System.out.println("£" +price3+ " " + dish3);
        
        
        
                
        
        
    }

}