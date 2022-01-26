package com.buddin.classroster.dao;

import com.buddin.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author burhan
 * @date 29 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface StudentDao {
    
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int id);

}
