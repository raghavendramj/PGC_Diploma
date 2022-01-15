package com.learning.service;


import com.learning.entity.Course;
import com.learning.entity.Student;
import com.learning.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    Course getCourse(Long id);
    Course saveCourse(Course course);
    Course saveCourse(Course course, Teacher teacher, List<Student> students);
    Course deleteCourse(Long id);
}
