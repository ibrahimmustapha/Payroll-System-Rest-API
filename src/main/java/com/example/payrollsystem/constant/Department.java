package com.example.payrollsystem.constant;

public enum Department {
    INFORMATION_TECHNOLOGY("Information Technology"),
    ACCOUNTING("Accounting"),
    SALES("Sales"),
    MARKETING("Marketing"),
    HUMAN_RESOURCE("Human Resource"),
    OPERATIONS("Operations");

    private final String value;

     Department(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
