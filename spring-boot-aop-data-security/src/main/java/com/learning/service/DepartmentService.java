package com.learning.service;

import com.learning.entity.Department;
import com.learning.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    //CREATE
    Department saveDepartment(Department department);


    //READ
    List<Department> getDepartments();

    //READ
    Department getDepartmentsById(Long departmentId) throws DepartmentNotFoundException;

    //READ
    Department getDepartmentsByName(String departmentName);

    //UPDATE
    Department updateDepartment(Long departmentId, Department department);


    //DELETE
    Department deleteDepartment(Long departmentId) throws DepartmentNotFoundException;

}
