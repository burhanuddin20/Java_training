/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 28/07/2021 
 * purpose: 
 */
package com.buddin.studentmcv;

public class MVCPatternDemo {
    
    public static void main(String[] args) {
        
        // this is where everything runs from
        
        // going to use the view first
        // only using this to test 
        Student model = retrieveStudentFromDatabse();
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(view, model);
        controller.updateView();
        
        // How to upadte the data
        controller.setRollNum(2);
        
        controller.updateView();
        
        
        
    }
    
    
    public static Student retrieveStudentFromDatabse(){
        
        Student student = new Student();
        
        student.setName("Burhan");
        student.setRollNum(1);
        return student;

    }
    
}
