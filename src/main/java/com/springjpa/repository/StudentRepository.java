package com.springjpa.repository;

import com.springjpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameIgnoreCaseContainingOrDepartmentNameContainingIgnoreCase(String studentKeyword, String departmentKeyword);
}
