package com.example.payrollsystem.controller;

import com.example.payrollsystem.model.JobDepartment;
import com.example.payrollsystem.service.JobDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class JobDepartmentController {

    private final JobDepartmentService jobDepartmentService;

    public JobDepartmentController(JobDepartmentService jobDepartmentService) {
        this.jobDepartmentService = jobDepartmentService;
    }

    @GetMapping
    public List<JobDepartment> getJobDepartment() {
        return jobDepartmentService.getJobDepartment();
    }

    @PostMapping
    public void addNewJobDepartment(@RequestBody JobDepartment jobDepartment) {
        jobDepartmentService.addNewJobDepartment(jobDepartment);
    }
}
