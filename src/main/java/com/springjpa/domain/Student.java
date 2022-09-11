package com.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer rollNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department", referencedColumnName = "departmentId")
    @JsonBackReference
    Set<Department> department = new HashSet<>();


}
