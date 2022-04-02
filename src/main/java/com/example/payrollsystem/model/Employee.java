package com.example.payrollsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private Integer employeeAge;
    private LocalDate employeeDateOfBirth;
    private String employeeAddress;
    private String employeeContact;
    private String employeeDepartment;
    private String employeeGender;
    private String employeeJobTitle;
    private Double employeeSalary;

    public Employee() {

    }

    public Employee(Integer employeeId, String employeeFirstName, String employeeLastName,
                    String employeeEmail, Integer employeeAge, LocalDate employeeDateOfBirth,
                    String employeeAddress, String employeeContact, String employeeDepartment,
                    String employeeGender, String employeeJobTitle, Double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
        this.employeeDepartment = employeeDepartment;
        this.employeeGender = employeeGender;
        this.employeeJobTitle = employeeJobTitle;
        this.employeeSalary = employeeSalary;
    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail,
                    Integer employeeAge, LocalDate employeeDateOfBirth, String employeeAddress,
                    String employeeContact, String employeeDepartment,
                    String employeeGender, String employeeJobTitle, Double employeeSalary) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
        this.employeeDepartment = employeeDepartment;
        this.employeeGender = employeeGender;
        this.employeeJobTitle = employeeJobTitle;
        this.employeeSalary = employeeSalary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public LocalDate getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(LocalDate employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeJobTitle() {
        return employeeJobTitle;
    }

    public void setEmployeeJobTitle(String employeeJobTitle) {
        this.employeeJobTitle = employeeJobTitle;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeDateOfBirth=" + employeeDateOfBirth +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeContact='" + employeeContact + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeJobTitle='" + employeeJobTitle + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}