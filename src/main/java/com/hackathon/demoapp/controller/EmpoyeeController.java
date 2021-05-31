package com.hackathon.demoapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.demoapp.model.Employee;
import com.hackathon.demoapp.model.EmployeeShallowDto;
import com.hackathon.demoapp.repo.EmployeRepo;

import io.swagger.annotations.ApiOperation;

@RestController  
@RequestMapping(value = "/api/v1/emp", produces = "application/json")
public class EmpoyeeController {

    @Autowired
    private EmployeRepo repo;
    
    @ApiOperation(value = "allemp")
    @GetMapping(path = "allemp")
    public List<EmployeeShallowDto> getAllEmployee()   
    {  
       return repo.getAllEmployee().stream().
               map(e -> new EmployeeShallowDto(e.getEmpId(),e.getFirstName(),e.getLastName()))
               .collect(Collectors.toList());
    } 
    @ApiOperation(value = "allempcount")
    @GetMapping(path = "allempcount")
    public Integer getAllEmployeeCount()   
    {  
       return repo.getAllEmployeeCount();
    } 
    @ApiOperation(value = "Save employees", notes = "save employee in DB")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee(@RequestBody List<Employee> empList) {
        repo.saveAll(empList);
    }
    
    @ApiOperation(value = "deleteall")
    @GetMapping(path = "deleteAll")
    public String deleteAllEmployee()   
    {  
        repo.deleteAllEmployee();
        return "Deleted";
    } 
}
