package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.EmployeeRepository;
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

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("employee with id::" + employeeId + " not fount."));
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }

    public String deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with id::" + employeeId + " is deleted";
    }
}
