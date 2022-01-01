package com.learning.service;

import com.learning.entity.Student;

import java.util.List;

public interface StudentService {

    //CREATE
    Student saveStudent(Student student);


    //READ
    List<Student> getStudents();
    Student getStudentByFullName(String firstName, String lastName);
    Student getStudentByEmailId(String emailId);
    Student getStudentById(Long id);

    //UPDATE
    Student updateStudent(Long id, Student student);

    //DELETE
    Student deleteStudent(Long id);
}
