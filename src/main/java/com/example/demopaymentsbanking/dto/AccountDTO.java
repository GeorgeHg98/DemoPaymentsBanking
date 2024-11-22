package com.example.demopaymentsbanking.dto;

import com.example.demopaymentsbanking.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AccountDTO {
    private Integer id;
    private String clientName;
    private Date creationDate;
    private double balance;
    private String iban;
    private Client client;

    public AccountDTO() {
    }

    public AccountDTO(Integer id, String clientName, Date creationDate, double balance, String iban, Client client) {
        this.id = id;
        this.clientName = clientName;
        this.creationDate = creationDate;
        this.balance = balance;
        this.iban = iban;
        this.client = client;
    }
}
