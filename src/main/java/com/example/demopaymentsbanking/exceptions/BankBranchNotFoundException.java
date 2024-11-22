package com.example.demopaymentsbanking.exceptions;

public class BankBranchNotFoundException extends RuntimeException {
    public BankBranchNotFoundException(String message) {
        super(message);
    }
}
