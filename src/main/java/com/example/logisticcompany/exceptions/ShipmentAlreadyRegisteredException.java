package com.example.logisticcompany.exceptions;

public class ShipmentAlreadyRegisteredException extends Exception{

    private String msg;

    public ShipmentAlreadyRegisteredException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ShipmentAlreadyRegisteredException [" + msg + "]";
    }
}
