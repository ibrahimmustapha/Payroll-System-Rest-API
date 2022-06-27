package com.example.payrollsystem.exception;

public class SalaryNotFoundException extends RuntimeException {
    public SalaryNotFoundException(String message) {
        super(message);
    }
}
