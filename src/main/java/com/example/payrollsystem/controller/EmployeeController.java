package com.example.payrollsystem.controller;

import com.example.payrollsystem.messaage.ResponseMessage;
import com.example.payrollsystem.model.Employee;
import com.example.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addNewEmployee(@RequestBody Employee employee) {
        String message = "";
        try {
            message = "Successfully added new employee data";
            employeeService.addNewEmployee(employee);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Failed to add a new employee";
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

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

    @PutMapping("/update-employee-image/{id}")
    public ResponseEntity<ResponseMessage> updateEmployeeImage (Employee employee, @PathVariable("id") String employeeId, @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            message = "Employee image uploaded successfully: " + employee.getEmployeeFirstName() + " " + employee.getEmployeeLastName();
            employeeService.addEmployeePhoto(employee, employeeId, file);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

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
