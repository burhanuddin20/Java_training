/*
 * @author burhan
 * email: burhan.u6@hotmail.co.uk
 * date:20/07/2021
 * purpose: Practice storing strings as variables
  * 
 */
package com.sg.foundations.variables;


public class TheOrderOfThings {
    
        public static void main(String[] args) {

        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "yellow";
        origin = "Martian";
        material = "platinum";
        purpose = "good";

        noun = "dragons";

        // Using the + with strings doesn't add -- it concatenates! (sticks them together)
        System.out.println(number + " " + age + " " + size + " " + opinion + " " + shape
                 + " " + color + " " + material + " " + purpose + " " + origin + " " + noun);
        // this sounds better
    }
    
}
