package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.EmployeeImageRepository;
import com.example.payrollsystem.model.EmployeeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

@Service
public class EmployeeImageService {

    @Autowired
    private EmployeeImageRepository employeeImageRepository;

    public EmployeeImage saveEmployeeImage(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        EmployeeImage employeeImage = new EmployeeImage(fileName, file.getContentType(), file.getBytes());
        return employeeImageRepository.save(employeeImage);
    }

    public EmployeeImage getEmployeeImage(String id) {
        return employeeImageRepository.findById(id).get();
    }

    public Stream<EmployeeImage> getAllEmployeeImages() {
        return employeeImageRepository.findAll().stream();
    }
}
