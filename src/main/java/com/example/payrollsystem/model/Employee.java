package com.example.payrollsystem.model;

import com.example.payrollsystem.constant.EmployeeGender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeGender employeeGender;
    @Nullable
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_image_id")
    private EmployeeImage employeeImage;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;

    public Employee() {

    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail, Integer employeeAge,
                    LocalDate employeeDateOfBirth, String employeeAddress,
                    String employeeContact, EmployeeGender employeeGender, @Nullable EmployeeImage employeeImage, Salary salary) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeAddress = employeeAddress;
        this.employeeContact = employeeContact;
        this.employeeGender = employeeGender;
        this.employeeImage = employeeImage;
        this.salary = salary;
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

    public EmployeeGender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(EmployeeGender employeeGender) {
        this.employeeGender = employeeGender;
    }

    public EmployeeImage getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(EmployeeImage employeeImage) {
        this.employeeImage = employeeImage;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}