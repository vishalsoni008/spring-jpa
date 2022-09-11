package com.springjpa.service;

import com.springjpa.domain.Department;
import com.springjpa.repository.DepartmentRepository;
import com.springjpa.request.DepartmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    public Department addDepartment(DepartmentRequest departmentRequest) {
        if(departmentRequest.getName() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please enter valid name");

        Department department = new Department();
        department.setName(departmentRequest.getName());

        department = departmentRepository.save(department);

        return department;
    }
}
