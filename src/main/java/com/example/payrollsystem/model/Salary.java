package com.example.payrollsystem.model;

import javax.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;
    @Column(nullable = false)
    private Double amount;
    @Transient
    private Double annualSalary;
    @Column(nullable = false)
    private Double salaryBonus;

    public Salary() {

    }

    public Salary(Integer salaryId, Double amount, Double annualSalary, Double salaryBonus) {
        this.salaryId = salaryId;
        this.amount = amount;
        this.annualSalary = annualSalary;
        this.salaryBonus = salaryBonus;
    }

    public Salary(Double amount, Double annualSalary, Double salaryBonus) {
        this.amount = amount;
        this.annualSalary = annualSalary;
        this.salaryBonus = salaryBonus;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAnnualSalary() {
        annualSalary = 12 * amount;
        return  annualSalary;
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

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", amount=" + amount +
                ", annualSalary=" + annualSalary +
                ", salaryBonus=" + salaryBonus +
                '}';
    }
}
