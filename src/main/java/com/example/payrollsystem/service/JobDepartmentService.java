package com.example.payrollsystem.service;

import com.example.payrollsystem.dao.JobDepartmentRepository;
import com.example.payrollsystem.exception.JobDepartmentNotFoundException;
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

    public JobDepartment updateJobDepartment(JobDepartment jobDepartment, Integer jobDepartmentId) {
        JobDepartment existingJobDepartment = jobDepartmentRepository.findById(jobDepartmentId)
                .orElseThrow(() -> new JobDepartmentNotFoundException("Job Department with id::" + jobDepartmentId + " not found."));
        jobDepartment.setJobDept(jobDepartment.getJobDept());
        jobDepartment.setJobName(jobDepartment.getJobName());
        jobDepartment.setJobDescription(jobDepartment.getJobDescription());
        jobDepartment.setJobPosition(jobDepartment.getJobPosition());
        return jobDepartmentRepository.save(jobDepartment);
    }
}
