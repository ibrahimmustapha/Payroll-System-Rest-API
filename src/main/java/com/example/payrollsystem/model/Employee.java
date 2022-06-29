package com.example.payrollsystem.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    @Column(length = 128)
    private String employeeId;
    @Column(nullable = false)
    private String employeeFirstName;
    @Column(nullable = false)
    private String employeeLastName;
    @Column(nullable = false)
    private String employeeEmail;
    @Transient
    private Integer employeeAge;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employeeDateOfBirth;
    @Column(nullable = false)
    private String employeeAddress;
    @Column(nullable = false)
    private String employeeContact;
    @Column(nullable = false)
    private String employeeGender;

    public Employee() {

    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail, Integer employeeAge,
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
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
        return LocalDate.now().getYear() - employeeDateOfBirth.getYear();
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