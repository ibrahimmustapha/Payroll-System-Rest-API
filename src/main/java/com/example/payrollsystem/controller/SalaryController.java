package com.example.payrollsystem.controller;

import com.example.payrollsystem.messaage.ResponseMessage;
import com.example.payrollsystem.model.Salary;
import com.example.payrollsystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<Salary> getSalaries() {
        return salaryService.getSalaries();
    }

    @GetMapping("/{id}")
    public Salary getSalary(@PathVariable("id") Integer salaryId) {
        return salaryService.getSalary(salaryId);
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addNewSalary(@RequestBody Salary salary) {
        String message = "";
        try {
            message = "New employee salary updated successfully";
            salaryService.addNewSalary(salary);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "failed to add new employee salary";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateSalary(@RequestBody Salary salary, @PathVariable("id") Integer salaryId) {
        String message = "";
         try {
             message = "employee with salary id:: " + salaryId + " has been updated successfully";
             salaryService.updateSalary(salary, salaryId);
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
         } catch (Exception e) {
             message = "failed to update employee with salary id:: " + salaryId;
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
         }
    }
}
