package com.example.payrollsystem.controller;

import com.example.payrollsystem.model.Salary;
import com.example.payrollsystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addNewSalary(@RequestBody Salary salary) {
        salaryService.addNewSalary(salary);
    }

    @PutMapping("/update/{id}")
    public Salary updateSalary(@RequestBody Salary salary, @PathVariable("id") Integer salaryId) {
        return salaryService.updateSalary(salary, salaryId);
    }
}
