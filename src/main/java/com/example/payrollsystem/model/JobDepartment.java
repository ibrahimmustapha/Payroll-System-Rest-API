package com.example.payrollsystem.model;

import com.example.payrollsystem.constant.Department;

import javax.persistence.*;

@Entity
public class JobDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;
    @Enumerated(EnumType.STRING)
    private Department jobDept;
    private String jobName;
    private String jobDescription;
    private String jobPosition;

    public JobDepartment() {}

    public JobDepartment(Department jobDept, String jobName, String jobDescription, String jobPosition) {
        this.jobDept = jobDept;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobPosition = jobPosition;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Department getJobDept() {
        return jobDept;
    }

    public void setJobDept(Department jobDept) {
        this.jobDept = jobDept;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public String toString() {
        return "JobDepartment{" +
                "jobId=" + jobId +
                ", jobDept=" + jobDept +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                '}';
    }
}

