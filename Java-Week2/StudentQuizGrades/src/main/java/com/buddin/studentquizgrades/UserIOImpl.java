
package com.buddin.studentquizgrades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.imageio.spi.ImageReaderSpi;

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
    // output the menu of options
    public void menu() {
        System.out.println("Choose an option: "
                + "\n1. View a list of all the students"
                + "\n2. Add a student to the system"
                + "\n3. Remove a student from the system"
                + "\n4. View a list of quiz scores for a given student"
                + "\n5. View the average quiz score for a given student "
                +"\n6. Exit program");
    }

    @Override
    
    public String readString(String message) {
        System.out.println(message);
        String name = userInput.next();
        return name;
        
    }

    @Override
    public ArrayList<Integer> readNum(ArrayList<Integer> grades) {
       
        while(userInput.hasNextInt()){
            System.out.println("Enter grade:");
            int num = Integer.parseInt(userInput.nextLine());
            grades.add(num);
        }
        return grades;
        
    }
    
    
     @Override
    public int readOption() {
        
       
        int option = Integer.parseInt(userInput.nextLine());
            return option;
         
        }
        
        
    

    @Override
    public void listStudents(Set <String> nameList) {
        
    // takes the gradebook map as input
    // View all the students in the system
        for(String name: nameList){
        System.out.println(name);
        
        }
    }
        
    

    @Override
    public void removeStudent(String name ,Map<String, ArrayList> gradeBook) {
        System.out.println("Enter student to remove");
        gradeBook.remove(name);
        System.out.println("Successfully removed");
    }
      
    }

    @Override
    public void quizScore(String StudentView) {
      

    @Override
    public void avgQuizScore() {
     
    }
}