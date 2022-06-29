package com.example.payrollsystem.exception;

public class JobDepartmentNotFoundException extends RuntimeException {
    public JobDepartmentNotFoundException (String message) {
        super(message);
    }
}
