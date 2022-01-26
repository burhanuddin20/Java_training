

import java.time.MonthDay;
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
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What day is it?");
        String userDay = scanner.nextLine();
        String upperDay = userDay.toUpperCase();
        
        DayEnum day  = DayEnum.valueOf(upperDay);
        
        System.out.println(daysTillFriday(day));
        
        
        
    }
    
    
    public static String daysTillFriday (DayEnum day){
        
        switch(day){
        
        case MONDAY:
            return("4 days till friday");

            
        case TUESDAY:
            return("3 days till friday");
      
            
        case WEDNESDAY:
            return("2 days till friday");
         
        case THURSDAY:
            return("1 days till friday");
            
        
        case FRIDAY:
           return("Today is Friday");
            
        
        case SATURDAY:
            return("6 days till friday");
        
            
        case SUNDAY:
            return "5 days till friday";
  
        }
    }   
}    
    
