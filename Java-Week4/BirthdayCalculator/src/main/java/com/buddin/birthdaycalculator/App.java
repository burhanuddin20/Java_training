
package com.buddin.birthdaycalculator;

import static com.buddin.birthdaycalculator.BirthdayCalculator.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author burhan
 * @date 13 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {
    
    public static void main(String[] args) {
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        // get dob
        System.out.println("Enter your birthday ");
        String date = scanner.nextLine();
        
        // store as local date object and parse it
        LocalDate  birthday = LocalDate.parse(date, formatter);
        
        // use day of week method
        DayOfWeek day = birthDay(birthday);

        System.out.println("You were born on a " + day);
      
        
        DayOfWeek currentYearDay = thisYearsDay(birthday);
        
      
        
        System.out.println("This year your birthday is on a " + currentYearDay);
        
        System.out.println("Todays date is " + LocalDate.now().format(formatter));
        
        
        System.out.println("There is  " + daysLeft(birthday)+" day(s) till your birthday");
        
        
        
    }

}
