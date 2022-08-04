package com.example.payrollsystem.controller;

import com.example.payrollsystem.messaage.ResponseMessage;
import com.example.payrollsystem.model.Employee;

import com.example.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Cacheable;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/payroll")
@Cacheable
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get data of all employees
    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // get an employee data based on their id
    @GetMapping(value = "/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    // add new employee
    @PostMapping(value = "/add-new-employee", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ResponseMessage> addNewEmployee (@RequestPart("data") Employee employee, @RequestPart("file") MultipartFile file) {
        String message = "";
        try {
            message = "Employee image uploaded successfully: " + employee.getEmployeeFirstName() + " " + employee.getEmployeeLastName();
            employeeService.addNewEmployee(employee, file);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    // update employee based their id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateEmployee (@RequestBody Employee employee, @PathVariable("id") String employeeId) {
        String message = "";
        try {
            message = "employee with id:: " + employeeId + " has been updated successfully.";
            employeeService.updateEmployee(employee, employeeId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "employee with id:: " + employeeId + " has not being updated :(";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    // delete an employee based on their id
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable("employeeId") String employeeId) {
        String message = "";
        try {
            message = "employee with id:: " + employeeId + " deleted";
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "employee with id:: " + employeeId + " has not been deleted.";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}
