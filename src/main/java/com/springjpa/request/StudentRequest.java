package com.springjpa.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRequest {


    private String name;

    private Integer rollNumber;

    private Integer departmentId;
}
