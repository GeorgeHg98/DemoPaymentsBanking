package com.example.demopaymentsbanking.dto;

import com.example.demopaymentsbanking.entity.BankBranch;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private BankBranch bankBranch;

    public EmployeeDTO() {}

    public EmployeeDTO(Integer id, String name, String surname, BankBranch bankBranch) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bankBranch = bankBranch;
    }

}
