package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.EmployeeRepository;
import com.example.payrollsystem.exception.EmployeeNotFoundException;
import com.example.payrollsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // return all list of available employee
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // return an employee data
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("employee with id::" + employeeId + " not fount."));
    }

    // add a new employee
    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }

    // update employee
    public Employee updateEmployee(Employee employee, Integer employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new EmployeeNotFoundException("Employee with id::" + employeeId + " not found."));
        employee.setEmployeeFirstName(employee.getEmployeeFirstName());
        employee.setEmployeeLastName(employee.getEmployeeLastName());
        employee.setEmployeeEmail(employee.getEmployeeEmail());
        employee.setEmployeeAge(employee.getEmployeeAge());
        employee.setEmployeeAddress(employee.getEmployeeAddress());
        employee.setEmployeeDateOfBirth(employee.getEmployeeDateOfBirth());
        employee.setEmployeeAddress(employee.getEmployeeAddress());
        employee.setEmployeeContact(employee.getEmployeeContact());
        employee.setEmployeeGender(employee.getEmployeeGender());
        return employeeRepository.save(employee);
    }

    // delete employee
    public String deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with id::" + employeeId + " has been deleted";
    }
}
