package com.springjpa.service;

import com.springjpa.domain.Department;
import com.springjpa.domain.Student;
import com.springjpa.repository.DepartmentRepository;
import com.springjpa.repository.StudentRepository;
import com.springjpa.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }

    public Student addStudent(StudentRequest studentRequest) {

        if(studentRequest.getName() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"please enter a name");

        if(studentRequest.getRollNumber() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"please enter a valid roll number");

        Department department = departmentRepository.findById(studentRequest.getDepartmentId()).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.BAD_REQUEST, "please enter valid departmet Id"));

        Set<Department> departmentSet = new HashSet<>(Collections.singleton(department));

        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setRollNumber(studentRequest.getRollNumber());
        student.setDepartment(departmentSet);

        student = studentRepository.save(student);

        return student;
    }

    public List<Student> searchStudentAndDepartment(String keyword) {
        return studentRepository.findByNameIgnoreCaseContainingOrDepartmentNameContainingIgnoreCase(keyword, keyword)
                .stream().collect(Collectors.toList());
    }
}
