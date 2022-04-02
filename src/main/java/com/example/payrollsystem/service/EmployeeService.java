package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.EmployeeRepository;
import com.example.payrollsystem.constant.Department;
import com.example.payrollsystem.model.Employee;
import com.example.payrollsystem.constant.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return List.of( new Employee(
                1,
                "Ibrahim",
                "Mustapha",
                "mustapha@gmail.com",
                22,
                LocalDate.of(2000, Month.MARCH, 6),
                "Nii Darko Street",
                "0547812542",
                Department.INFORMATION_TECHNOLOGY.getValue(),
                Gender.M.toString(),
                "Backend Engineer",
                4500.00
        ));
    }
}
