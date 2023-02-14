package com.example.logisticcompany.exceptions;

public class OfficeAlreadyExistsException extends Exception {

    private String msg;

    public OfficeAlreadyExistsException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "OfficeAlreadyExistsException [" + msg + "]";
    }
}
