
package com.buddin.birthdaycalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author burhan
 * @date 13 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class BirthdayCalculator {

/*    


Next tell them what day it is today & the number of days until their next birthday...
And how many years old they will be!
*/
    
    // method calcualtes the day someone was born
    // return a day of week object
    public static DayOfWeek birthDay(LocalDate dob){
        
        // dayofweek obj called day 
        // uses built in method getdayofweek
        DayOfWeek day = dob.getDayOfWeek();
        
        return day;
           
    
    }
    
    public  static LocalDate currentBirthDay(LocalDate dob){
    
        
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      // take the day and month
      // get the month value / Leading zero missing
      int month = dob.getMonthValue();
      // get the day value /
      int dayValue = dob.getDayOfMonth();
      
      // get the current year
      int year= LocalDate.now().getYear();
      
      // create the current year birthday
      LocalDate currentYearBirthDay;
      if(month <10){
        currentYearBirthDay =  LocalDate.parse(dayValue+"/0"+month+"/"+year,formatter);
      }
      else{
        currentYearBirthDay =  LocalDate.parse(dayValue+"/0"+month+"/"+year,formatter);
      
      }
        
      
      return currentYearBirthDay;
     
    }
    
    
    public static DayOfWeek thisYearsDay(LocalDate dob){
    
     LocalDate currentYear = currentBirthDay(dob);
     DayOfWeek day = currentYear.getDayOfWeek();
     
     return day;
    
    }
    
    public static long daysLeft(LocalDate dob) {
    long days = ChronoUnit.DAYS.between(LocalDate.now(),currentBirthDay(dob));  
    
       
    
    return days;
        
    }
    
    
    
    
}
