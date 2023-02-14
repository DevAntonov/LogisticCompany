package com.example.logisticcompany.model;

public enum Role {
    OFFICEWORKER("OfficeWorker"),
    CLIENT ("Client"),
    COURIER("Courier"),
    USER("User"),
    ADMIN("Admin");



    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
