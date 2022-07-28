package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.SalaryRepository;
import com.example.payrollsystem.exception.SalaryNotFoundException;
import com.example.payrollsystem.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Salary getSalary(Integer salaryId) {
        return salaryRepository.findById(salaryId)
                .orElseThrow(() -> new SalaryNotFoundException("Salary of employee with id::" + salaryId + " not found"));
    }

    // add a new salary
    public void addNewSalary(Salary salary) {
        try {
            salaryRepository.save(salary);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    // update employee salary
    public Salary updateSalary(Salary salary, Integer salaryId) {
        Salary existingSalary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new SalaryNotFoundException("Employee with salary id::" + salaryId + " not found."));
        salary.setSalary(salary.getSalary());
        salary.setSalaryBonus(salary.getAnnualSalary());
        return salaryRepository.save(salary);
    }
}
