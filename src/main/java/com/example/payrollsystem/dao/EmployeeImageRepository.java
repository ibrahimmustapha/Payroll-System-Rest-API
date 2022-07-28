package com.example.payrollsystem.dao;

import com.example.payrollsystem.model.EmployeeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeImageRepository extends JpaRepository<EmployeeImage, String> {
}
