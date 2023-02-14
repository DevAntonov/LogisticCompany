package com.example.logisticcompany.exceptions;

public class EmployeeAlreadyAssignedToCompanyException extends Exception{

    private String msg;

    public EmployeeAlreadyAssignedToCompanyException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EmployeeAlreadyAssignedToCompanyException [" + msg + "]";
    }
}
