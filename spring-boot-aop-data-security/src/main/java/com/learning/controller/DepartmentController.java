package com.learning.controller;

import com.learning.entity.Department;
import com.learning.error.DepartmentNotFoundException;
import com.learning.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String departmentHome(){
        return "Welcome to the departments home";
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("Inside the saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        LOGGER.info("Inside the getDepartments of DepartmentController");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside the getDepartmentById of DepartmentController");
        return departmentService.getDepartmentsById(departmentId);

    }
    @GetMapping("/searchDepartments")
    public Department getDepartmentById(@RequestParam("name") String departmentName) {
        LOGGER.info("Inside the getDepartmentsByName of DepartmentController");
        return departmentService.getDepartmentsByName(departmentName);
    }


    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside the updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/departments/{id}")
    public Department deleteDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside the deleteDepartment of DepartmentController");
        return departmentService.deleteDepartment(departmentId);
    }
}
