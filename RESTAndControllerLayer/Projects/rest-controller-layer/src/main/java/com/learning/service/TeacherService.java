package com.learning.service;

import com.learning.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeachers();
    Teacher getTeacher(Long id);
    Teacher saveTeacher(Teacher teacher);
    Teacher deleteTeacher(Long id);
}
