package com.learning.controller;

import com.learning.entity.Course;
import com.learning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable("id") Long id) {
        return courseService.deleteCourse(id);
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

}
