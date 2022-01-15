package com.learning.controller;

import com.learning.entity.Teacher;
import com.learning.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") Long id) {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/{id}")
    public Teacher deleteTeacher(@PathVariable("id") Long id) {
        return teacherService.deleteTeacher(id);
    }

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

}
