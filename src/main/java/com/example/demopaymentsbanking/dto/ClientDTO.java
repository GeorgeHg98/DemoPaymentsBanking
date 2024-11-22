package com.example.demopaymentsbanking.dto;

import com.example.demopaymentsbanking.entity.Account;
import com.example.demopaymentsbanking.entity.BankBranch;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private Account account;
    private BankBranch bankBranch;

    public ClientDTO() {
    }

    public ClientDTO(Integer id, String name, String surname, Account account, BankBranch bankBranch) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.bankBranch = bankBranch;
    }
}
