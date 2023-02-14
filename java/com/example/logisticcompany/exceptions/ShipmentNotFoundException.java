package com.example.logisticcompany.exceptions;

public class ShipmentNotFoundException extends Exception {

    private String msg;

    public ShipmentNotFoundException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ShipmentNotFoundException [" + msg + "]";
    }
}
