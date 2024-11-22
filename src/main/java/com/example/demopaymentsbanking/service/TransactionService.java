package com.example.demopaymentsbanking.service;

import com.example.demopaymentsbanking.entity.Transaction;
import com.example.demopaymentsbanking.exceptions.TransactionNotFoundException;
import com.example.demopaymentsbanking.repository.TransactionRepository;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ResponseEntity<Transaction> create(Transaction transaction) {
        return ResponseEntity.ok(transactionRepository.save(transaction));
    }

    @SneakyThrows
    public ResponseEntity<Transaction> findTransactionById(Integer id) {
        return ResponseEntity.ok(transactionRepository.findTransactionById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction not found!")));
    }

    public ResponseEntity<List<Transaction>> findAllTransactionsByAccountId(Integer id) {
        return ResponseEntity.ok(transactionRepository.findTransactionByAccountId(id));
    }
}
