package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.SalaryRepository;
import com.example.payrollsystem.exception.SalaryNotFoundException;
import com.example.payrollsystem.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    // get all employee salaries
    public List<Salary> getSalaries() {
        return salaryRepository.findAll();
    }

    // get the salary of an employee
    public Salary getSalary(String salaryId) {
        return salaryRepository.findById(salaryId)
                .orElseThrow(() -> new SalaryNotFoundException("Salary of employee with id::" + salaryId + " not found"));
    }
}
