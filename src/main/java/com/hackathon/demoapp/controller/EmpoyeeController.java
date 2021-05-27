package com.hackathon.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.demoapp.model.Employee;
import com.hackathon.demoapp.repo.EmployeRepo;

import io.swagger.annotations.ApiOperation;

@RestController  
@RequestMapping(value = "/api/v1/emp", produces = "application/json")
public class EmpoyeeController {

    @Autowired
    private EmployeRepo repo;
    
    @ApiOperation(value = "allemp")
    @GetMapping(path = "allemp")
    public List<Employee> getAllEmployee()   
    {  
       return repo.getAllEmployee();
    } 
    
    @ApiOperation(value = "Save employees", notes = "save employee in DB")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee(@RequestBody List<Employee> empList) {
        repo.saveAll(empList);
    }
}
