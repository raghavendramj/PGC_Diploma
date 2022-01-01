package com.learning.service.impl;

import com.learning.entity.Student;
import com.learning.repository.StudentRepostitory;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepostitory studentRepostitory;

    @Override
    public Student saveStudent(Student student) {
        return studentRepostitory.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepostitory.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepostitory.findById(id);

        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

    @Override
    public Student getStudentByFullName(String firstName, String lastName) {
        return studentRepostitory.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Student getStudentByEmailId(String emailId) {
        return studentRepostitory.findByEmailId(emailId);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        //Verify the student
        Optional<Student> optionalStudent = studentRepostitory.findById(id);

        if (optionalStudent.isPresent()) {
            //then update the student
            return studentRepostitory.save(student);
        }
        return null;
    }

    @Override
    public Student deleteStudent(Long id) {
        //Verify the student
        Optional<Student> optionalStudent = studentRepostitory.findById(id);

        if (optionalStudent.isPresent()) {
            //then delete the student
            Student studentToDelete = optionalStudent.get();
            studentRepostitory.delete(studentToDelete);
            return studentToDelete;
        }
        return null;
    }
}
