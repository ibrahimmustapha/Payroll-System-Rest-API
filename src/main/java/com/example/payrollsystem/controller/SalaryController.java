package com.example.payrollsystem.controller;

import com.example.payrollsystem.model.Salary;
import com.example.payrollsystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payroll")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/salaries")
    public List<Salary> getSalaries() {
        return salaryService.getSalaries();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalary(@PathVariable("id") String salaryId) {
        return salaryService.getSalary(salaryId);
    }

}
