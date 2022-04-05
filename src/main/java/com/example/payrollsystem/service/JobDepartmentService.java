package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.JobDepartmentRepository;
import com.example.payrollsystem.model.JobDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDepartmentService {

    private final JobDepartmentRepository jobDepartmentRepository;

    @Autowired
    public JobDepartmentService(JobDepartmentRepository jobDepartmentRepository) {
        this.jobDepartmentRepository = jobDepartmentRepository;
    }

    public List<JobDepartment> getJobDepartment() {
        return jobDepartmentRepository.findAll();
    }

    public void addNewJobDepartment(JobDepartment jobDepartment) {
        try {
            jobDepartmentRepository.save(jobDepartment);
        } catch (RuntimeException e) {
            e.printStackTrace();
            ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No such depart as::" + jobDepartment.getJobDept());
        }
    }
}
