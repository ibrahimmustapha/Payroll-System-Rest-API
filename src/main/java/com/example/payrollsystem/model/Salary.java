package com.example.payrollsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String salaryId;
    private Double hourlyRate;
    private Double salaryBonus;
    private Double tax;
    private Double insurance;
    private Integer workingHoursPerDay;
    @Transient
    private Double netIncome;
    @Transient
    private Double grossIncome;
    @Transient
    private Double annualSalary;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "salary")
    private Employee employee;

    public Salary() {

    }

    public Salary(Double hourlyRate, Double salaryBonus, Double grossIncome, Double netIncome, Double annualSalary,
                  Double tax, Double insurance, Integer workingHoursPerDay) {
        this.annualSalary = annualSalary;
        this.hourlyRate = hourlyRate;
        this.salaryBonus = salaryBonus;
        this.netIncome = netIncome;
        this.grossIncome = grossIncome;
        this.tax = tax;
        this.insurance = insurance;
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public Double getAnnualSalary() {
        double totalNetIncome = (hourlyRate * workingHoursPerDay * 23 + salaryBonus) - (tax + insurance);
            return totalNetIncome * 12;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(Double salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public Double getNetIncome() {
        Double totalGrossIncome = hourlyRate * workingHoursPerDay * 23 + salaryBonus;
        Double totalExpenses = tax + insurance;
        return totalGrossIncome - totalExpenses;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }

    public Double getGrossIncome() {
        return hourlyRate * workingHoursPerDay * 23 + salaryBonus;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Integer getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }
}
