package com.example.payrollsystem.model;

import javax.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;
    @Column(nullable = false)
    private Double salary;
    @Transient
    private Double annualSalary;
    @Column(nullable = false)
    private Double salaryBonus;

    public Salary() {

    }

    public Salary(Double salary, Double annualSalary, Double salaryBonus) {
        this.salary = salary;
        this.annualSalary = annualSalary;
        this.salaryBonus = salaryBonus;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Double getSalary() {
        return salary * 12;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(Double salaryBonus) {
        this.salaryBonus = salaryBonus;
    }
}
