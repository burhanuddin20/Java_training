
package com.buddin.studentquizgrades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author burhan
 * @date 31 Jul 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface UserIO {
    // this class should take all input and output
    
    // for outputting messages
    void  print(String message);
    
    // give the user menu
    
    void menu();
    
    String readString(String message);
    
    int readOption();
    
    ArrayList<Integer> readNum(ArrayList<Integer> grades );
    
    // return all objects created as they are all students
    void listStudents(Set <String> nameList);
    
    // need name, key and scores
    // make each student a object
    
    // give the student names
    void removeStudent(String name,Map<String, ArrayList> gradeBook);
    
    // for a given student
    void quizScore();
    void avgQuizScore();
    
    
}
