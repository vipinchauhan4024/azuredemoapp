package com.hackathon.demoapp.model;

import lombok.Data;

@Data
public class Employee {
    private int empId;
    private String empname;
    private String dept;
    public Employee(){}
    public Employee(int empId, String empname, String dept) {
        super();
        this.empId = empId;
        this.empname = empname;
        this.dept = dept;
    }
    
    
}
