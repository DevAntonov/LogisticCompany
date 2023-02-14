package com.example.logisticcompany.exceptions;

public class CompanyWithThatNameAlreadyExistsException extends Exception{

    private String msg;

    public CompanyWithThatNameAlreadyExistsException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CompanyWithThatNameAlreadyExistsException [" + msg + "]";
    }
}
