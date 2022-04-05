package com.example.payrollsystem.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employeeDateOfBirth;
    private String employeeAddress;
    private String employeeContact;
    private String employeeGender;

    public Employee() {

    }

    public Employee(String employeeFirstName, String employeeLastName,
                    String employeeEmail, Integer employeeAge,
                    LocalDate employeeDateOfBirth, String employeeAddress,
                    String employeeContact, String employeeGender) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
        this.employeeGender = employeeGender;
    }

    public Employee(Integer employeeId, String employeeFirstName, String employeeLastName,
                    String employeeEmail, Integer employeeAge,
                    LocalDate employeeDateOfBirth, String employeeAddress,
                    String employeeContact, String employeeGender) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
        this.employeeGender = employeeGender;
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

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
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
                ", employeeGender='" + employeeGender + '\'' +
                '}';
    }
}