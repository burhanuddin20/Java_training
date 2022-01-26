
package com.buddin.studentquizgrades;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;
/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class App {

    public static void main(String[] args) {
        
        // initiate the user IO
        UserIO UI = new UserIOImpl();
        
        // initiate a new hash mape
        Map <String, ArrayList> gradeBook = new HashMap<>();
        
        Set <String> nameList = gradeBook.keySet();
        ArrayList<Integer> grades = new ArrayList<>();
        
        boolean open = true;
        do {          
            //print the menu out
            UI.menu();
            // get menu option
            int option = UI.readOption();
            
            
            

            switch(option){
                case 1: //View list of all students
                    UI.listStudents(nameList);
                    break;
                        
                case 2: // Add a student to dataset
                    // get name
                    String newStudent = UI.readString("Enter student name: ");
                    // add to grade book
                    gradeBook.put(newStudent, new ArrayList<>(Arrays.asList()));
                    break;
                    
                case 3: //Remove a student
                
                    String student = UI.readString("Enter student to remove: ");
                    gradeBook.remove(student);
                 
                case 4: //View quiz scores for a particular student
                    String studentView = UI.readString("Enter student name to view: ");
                    // Set of names from gradeBook
                    UI.print(gradeBook.get(studentView));
          
                case 5: // view avg for a student
                    
                case 6:
                    System.exit(0);// Exit program
            }
            
        } while (open);
    }
    
    
    

}
