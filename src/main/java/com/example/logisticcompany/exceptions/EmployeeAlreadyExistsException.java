package com.example.logisticcompany.exceptions;

public class EmployeeAlreadyExistsException extends Exception{

    private String msg;

    public EmployeeAlreadyExistsException (String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EmployeeAlreadyExistsException [" + msg + "]";
    }
}
