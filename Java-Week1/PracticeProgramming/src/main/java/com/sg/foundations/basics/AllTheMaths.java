package com.sg.foundations.basics;

/**
 * @author burhan
 * email:burhan.u6@hotmail.co.uk
 * date: 20/07/2021 
 * purpose: Practice Basic Exercise
 */
public class AllTheMaths {
    
     public static void main(String[] args) {
         
        System.out.print("1 + 2 is: ");
        System.out.println(1 + 2);//3
        
        System.out.print("42001 modulus 5 is: ");
        System.out.println(42001 % 5);//1

        System.out.print("5565.0 divided by 22.0 is : ");
        System.out.println(5565.0 / 22.0);//252.95454545454547

        System.out.print("223 times 31 - 42: ");
        System.out.println(223 * 31 - 42);//6871

        System.out.print("Is 4 greater than -1? ");
        System.out.println(4 > -1);//True
        
        //Print new line
        System.out.println("\n****** Now make the computer do some harder math!");

        System.out.print("8043.52 minus 4.2 plus 23.0 divided by 56.0 times -76.13 is: ");
        System.out.println((8043.52 - 4.2 + 23.0) / (56*(-76.13)));
        //-1.8911073164324186

        System.out.print("11111 modulus 3 minus 67 minus 1 plus 9 is: ");
        System.out.println(11111 % 3 - 67 - 1 + 9);//-57

        System.out.print("44 minus 22 minus 11 minus 66 minus 88 minus 76 minus 11 minus 33 is : ");
        System.out.println(44-22-11-66-88-76-11-33);//-263

        System.out.print("22 times 3 minus 1 plus 4 times 6 minus -9 is : ");
        System.out.println(22 * 3 - 4 + 4 *6 -(-9));// 95

        System.out.print("Is 67 greater than 4 * 5? ");
        System.out.println(4 * 5 < 67); //true

        System.out.print("Is 78 less than 4 * 5? ");
        System.out.print(4 * 5 > 78); //false
    }
    
}
