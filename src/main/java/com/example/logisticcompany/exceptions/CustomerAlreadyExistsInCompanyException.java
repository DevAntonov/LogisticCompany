package com.example.logisticcompany.exceptions;

public class CustomerAlreadyExistsInCompanyException extends Exception {

    private String msg;

    public CustomerAlreadyExistsInCompanyException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CustomerAlreadyExistsInCompanyException [" + msg + "]";
    }
}
