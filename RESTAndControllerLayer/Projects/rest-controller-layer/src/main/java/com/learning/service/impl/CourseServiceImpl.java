package com.learning.service.impl;


import com.learning.entity.Course;
import com.learning.entity.Student;
import com.learning.entity.Teacher;
import com.learning.repository.CourseRepository;
import com.learning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        //select name from course where id=45;

        if (optionalCourse.isPresent())
            return optionalCourse.get();

        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course saveCourse(Course course, Teacher teacher, List<Student> students) {
        course.setTeacher(teacher);
        course.setStudents(students);
        return courseRepository.save(course);
    }

    @Override
    public Course deleteCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            courseRepository.delete(course);
            return course;
        }
        return null;
    }
}
