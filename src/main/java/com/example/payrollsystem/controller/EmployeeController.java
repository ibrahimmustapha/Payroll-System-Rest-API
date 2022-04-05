package com.example.payrollsystem.controller;

import com.example.payrollsystem.model.Employee;
import com.example.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
