package com.et.bean;

import lombok.Data;

@Data
public class Emp {
    private Integer empId;

    private String empName;

    private String gender;

    private String email;

    private Integer deptId;
    
    private Dept dept;

}