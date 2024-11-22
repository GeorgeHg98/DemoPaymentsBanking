package com.example.demopaymentsbanking.constants;

public enum TransactionType {
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    TRANSFER("TRANSFER");

    public final String label;

    TransactionType(String label) {
        this.label = label;
    }
}
