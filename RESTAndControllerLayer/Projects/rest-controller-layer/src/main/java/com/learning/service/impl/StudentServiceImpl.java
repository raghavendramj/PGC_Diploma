package com.learning.service.impl;


import com.learning.entity.Student;
import com.learning.repository.StudentRepository;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        //select name from student where id=45;

        if (optionalStudent.isPresent())
            return optionalStudent.get();

        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
            return student;
        }
        return null;
    }
}
