package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.SalaryRepository;
import com.example.payrollsystem.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    // get all employee salaries
    public List<Salary> getSalary() {
        return salaryRepository.findAll();
    }

    public void addNewSalary(Salary salary) {
        try {
            salaryRepository.save(salary);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
