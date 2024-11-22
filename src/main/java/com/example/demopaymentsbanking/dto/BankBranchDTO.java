package com.example.demopaymentsbanking.dto;

import com.example.demopaymentsbanking.entity.Client;
import com.example.demopaymentsbanking.entity.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BankBranchDTO {
    private Integer id;
    private String name;
    private List<Employee> employees;
    private List<Client> clients;

    public BankBranchDTO() {}

    public BankBranchDTO(Integer id, String name, List<Employee> employees, List<Client> clients) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.clients = clients;
    }
}
