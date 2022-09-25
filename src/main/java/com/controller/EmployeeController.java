package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return service.saveEmployees(employees);
    }

    @GetMapping("/Employees")
    public List<Employee> findAllEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/EmployeeByEmpId/{empId}")
    public Employee findEmployeeByEmpId(@PathVariable int empId) {
        return service.getEmployeeById(empId);
    }

	
	  @GetMapping("/Employee/{firstName}") 
	  public Employee findEmployeeByFirstName(@PathVariable String firstName) { return
	  service.getEmployeeByFirstName(firstName); }
	 

    @PutMapping("/Employee/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/Employee/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        return service.deleteEmployee(empId);
    }
}
