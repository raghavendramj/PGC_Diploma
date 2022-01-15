package com.learning.service;

import com.learning.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Long id);
    Student saveStudent(Student student);
    Student deleteStudent(Long id);
}
