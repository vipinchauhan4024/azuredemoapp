package com.hackathon.demoapp.model;

import lombok.Data;

@Data
public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String dob;
    private String age;
    private String doj ;
    private int yearOfJoining;
    
    private String yearsInCompany;
    private int salary;
    private String lastHike;
    private String phoneNo;
    private String county;
    private String city;
    private String state;
    private String region;
    private String userName;
    
    
    
    
    
    
    public Employee(){}
    public Employee(int empId, String firstName, String lastName) {
        super();
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
}
