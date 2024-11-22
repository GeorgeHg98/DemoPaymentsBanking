package com.example.demopaymentsbanking.service;

import com.example.demopaymentsbanking.entity.BankBranch;
import com.example.demopaymentsbanking.exceptions.BankBranchNotFoundException;
import com.example.demopaymentsbanking.repository.BankBranchRepository;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BankBranchService {

    private final BankBranchRepository bankBranchRepository;

    public BankBranchService(BankBranchRepository bankBranchRepository) {
        this.bankBranchRepository = bankBranchRepository;
    }
    public ResponseEntity<BankBranch> create(BankBranch bankBranch) {
        return ResponseEntity.ok(bankBranchRepository.save(bankBranch));
    }

    @SneakyThrows
    public ResponseEntity<BankBranch> delete(Integer id) {
        return ResponseEntity.ok(bankBranchRepository.deleteBankBranchById(id).orElseThrow(() -> new BankBranchNotFoundException("Bank Branch not found!")));
    }

    @SneakyThrows
    public ResponseEntity<BankBranch> findBankBranchByName(String name) {
        return ResponseEntity.ok(bankBranchRepository.findBankBranchByName(name).orElseThrow(() -> new BankBranchNotFoundException("Bank Branch not found!")));
    }

    @SneakyThrows
    public ResponseEntity<BankBranch> findBankBranchById(Integer id) {
        return ResponseEntity.ok(bankBranchRepository.findBankBranchById(id).orElseThrow(() -> new BankBranchNotFoundException("Bank Branch not found!")));

    }
}
