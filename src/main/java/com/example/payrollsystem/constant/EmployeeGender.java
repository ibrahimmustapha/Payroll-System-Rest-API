package com.example.payrollsystem.constant;

public enum EmployeeGender {
    Male("Male"),
    Female("Female");

    private final String value;

    EmployeeGender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
