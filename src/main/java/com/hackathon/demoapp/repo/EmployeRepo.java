package com.hackathon.demoapp.repo;

import java.util.List;

import com.hackathon.demoapp.model.Employee;

public interface EmployeRepo {

    List<Employee> getAllEmployee();

    void saveAll(List<Employee> empList);

    int getAllEmployeeCount();

    void deleteAllEmployee();

}
