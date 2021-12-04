package com.learning.service.impl;

import com.learning.entity.Department;
import com.learning.error.DepartmentNotFoundException;
import com.learning.repository.DepartmentRepository;
import com.learning.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentsById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

        if(!optionalDepartment.isPresent()){
            throw new DepartmentNotFoundException("From GET Department Not Available");
        }

        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department getDepartmentsByName(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

        if(!optionalDepartment.isPresent()){
            throw new DepartmentNotFoundException("From Delete -> Department Not Available");
        }

        Department department = optionalDepartment.get();
        departmentRepository.delete(department);
        return department;
    }
}
