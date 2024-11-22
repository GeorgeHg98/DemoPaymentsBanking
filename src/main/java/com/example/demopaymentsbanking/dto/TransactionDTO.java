package com.example.demopaymentsbanking.dto;

import com.example.demopaymentsbanking.constants.TransactionType;
import com.example.demopaymentsbanking.entity.Account;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TransactionDTO {
    private Integer id;
    private float amount;
    private Date date;
    private TransactionType transactionType;
    private Account fromAccount;
    private Account toAccount;

    public TransactionDTO() {}

    public TransactionDTO(Integer id, float amount, Date date, TransactionType transactionType, Account fromAccount, Account toAccount) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }
}
