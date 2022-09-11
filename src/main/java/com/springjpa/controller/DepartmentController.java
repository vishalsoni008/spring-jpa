package com.springjpa.controller;

import com.springjpa.request.DepartmentRequest;
import com.springjpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity getAllDepartment(){
        return new ResponseEntity(departmentService.getAllDepartment(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addDepartment(@RequestBody DepartmentRequest departmentRequest){
        return new ResponseEntity(departmentService.addDepartment(departmentRequest), HttpStatus.CREATED);
    }
}
