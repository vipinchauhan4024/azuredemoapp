package com.hackathon.demoapp.model;

import lombok.Data;

@Data
public class EmployeeShallowDto {

    private int empId;
    private String firstName;
    private String lastName;
    
    public EmployeeShallowDto(){
        
    }
    
    public EmployeeShallowDto(int empId, String firstName, String lastName) {
        super();
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
}
