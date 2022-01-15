package com.learning.service.impl;

import com.learning.entity.Course;
import com.learning.entity.Student;
import com.learning.entity.Teacher;
import com.learning.repository.TeacherRepository;
import com.learning.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        //select name from teacher where id=45;

        if (optionalTeacher.isPresent())
            return optionalTeacher.get();

        return null;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher deleteTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);

        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacherRepository.delete(teacher);
            return teacher;
        }
        return null;
    }
}
