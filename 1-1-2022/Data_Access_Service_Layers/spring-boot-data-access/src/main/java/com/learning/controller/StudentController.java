package com.learning.controller;

import com.learning.entity.Student;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/email/{emailId}")
    Student getStudentByEmail(@PathVariable("emailId") String emailId) {
        return studentService.getStudentByEmailId(emailId);
    }

    @GetMapping("/students/search")
    Student getStduentByFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return studentService.getStudentByFullName(firstName, lastName);
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    Student deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }

}
