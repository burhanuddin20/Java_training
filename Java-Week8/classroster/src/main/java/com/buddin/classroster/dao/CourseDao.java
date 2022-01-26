package com.buddin.classroster.dao;

import com.buddin.classroster.dto.Course;
import com.buddin.classroster.dto.Student;
import com.buddin.classroster.dto.Teacher;
import java.util.List;

/**
 *
 * @author burhan
 * @date 29 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public interface CourseDao {
    Course getCourseById(int id);
    List<Course> getAllCourses();
    Course addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    
    List<Course> getCoursesForTeacher(Teacher teacher);
    List<Course> getCoursesForStudent(Student student);
    

}
