package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.EmployeeImageRepository;
import com.example.payrollsystem.dao.EmployeeRepository;
import com.example.payrollsystem.exception.EmployeeNotFoundException;
import com.example.payrollsystem.messaage.ResponseMessage;
import com.example.payrollsystem.model.Employee;
import com.example.payrollsystem.model.EmployeeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeImageRepository employeeImageRepository;
    private static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images";

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeImageRepository employeeImageRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeImageRepository = employeeImageRepository;
    }

    // return all list of available employee
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // return an employee data
    public Employee getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("employee with id::" + employeeId + " not fount."));
    }

    // add employee photo
    public void addNewEmployee(Employee employee, MultipartFile file) {
        try {
            Optional<Employee> employeeOptional = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
            if (employeeOptional.isPresent()) throw new IllegalStateException("email taken");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            EmployeeImage employeeImage = new EmployeeImage(fileName, file.getContentType(), file.getBytes());
            employeeImageRepository.save(employeeImage);
            employee.setEmployeeImage(employeeImage);
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update employee
    public Employee updateEmployee(Employee employee, String employeeId) {
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
    public String deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with id::" + employeeId + " has been deleted";
    }
}
