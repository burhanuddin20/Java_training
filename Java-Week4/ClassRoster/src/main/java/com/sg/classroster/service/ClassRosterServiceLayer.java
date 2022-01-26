
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

/**
 * @author burhan
 * email:burhan.u6@hotmail.co.uk
 * date: 10/08/2021
 *purpose
 */


public interface ClassRosterServiceLayer {
 
    void createStudent(Student student) throws 
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
 
    List<Student> getAllStudents() throws 
            ClassRosterPersistenceException;
 
    Student getStudent(String studentId) throws 
            ClassRosterPersistenceException;
 
    Student removeStudent(String studentId) throws 
            ClassRosterPersistenceException;
 
}