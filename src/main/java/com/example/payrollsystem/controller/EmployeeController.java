package com.example.payrollsystem.controller;

import com.example.payrollsystem.model.Employee;
import com.example.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee employee (@RequestBody Employee employee, @PathVariable("id") String employeeId) {
        return employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
