package com.example.payrollsystem.dao;

import com.example.payrollsystem.model.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDepartmentRepository extends JpaRepository<JobDepartment, Integer> {
}
