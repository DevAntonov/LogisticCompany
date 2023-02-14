package com.example.logisticcompany.exceptions;

public class OfficeAlreadyAssignedToCompanyException extends Exception {

    private String msg;

    public OfficeAlreadyAssignedToCompanyException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "OfficeAlreadyAssignedToCompanyException [" + msg + "]";
    }
}
