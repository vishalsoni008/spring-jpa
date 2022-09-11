package com.springjpa.controller;

import com.springjpa.request.StudentRequest;
import com.springjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity getAllStudents(){
        return new ResponseEntity(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity(studentService.addStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity searchStudentAndDepartment(@RequestParam("keyword") String keyword){
        return new ResponseEntity(studentService.searchStudentAndDepartment(keyword), HttpStatus.OK);
    }
}
