
package com.buddin.classroster.dao;

import com.buddin.classroster.dto.Teacher;
import java.util.List;

/**
 *
 * @author burhan
 * @date 29 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface TeacherDao {
    
    Teacher getTeacherById(int id);
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacehr);
    void deleteTeacherById(int id);
    
    

}
