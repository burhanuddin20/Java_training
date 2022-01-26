/**
 * @author burhan
 * * email:burhan.u6@hotmail.co.uk
 * date: 28/07/2021 
 * purpose: 
 */
package com.buddin.studentmcv;


public class StudentController {
    
    private StudentView view; // property called view uses studentview type
    private Student model;//                     model     student 
  
       //constructor 
       public StudentController (StudentView view, Student model){
           this.view =  view;
           this.model =  model;
       }
       
       // define getters and setters to get the data
       
       // method to get name from Student class
       public String getName(){
            return model.getName();
           
       }
       
       // set name student.setName method
        public void setName(String name){
           model.setName(name);
           
       }
        
        // similarly for roll num
        
        public int getRollNum(){
        return model.getRollNum();
           
       }
       
       // set name student.setName method
        public void setRollNum (int rollNum){
           model.setRollNum(rollNum);
        }
        
        public void updateView(){
            view.printStudentDetails(model.getName(), model.getRollNum());
        
        }
           
    
}
