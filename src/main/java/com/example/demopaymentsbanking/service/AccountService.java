package com.example.demopaymentsbanking.service;

import com.example.demopaymentsbanking.entity.Account;
import com.example.demopaymentsbanking.entity.Client;
import com.example.demopaymentsbanking.exceptions.AccountNotFoundException;
import com.example.demopaymentsbanking.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Account> create(Account account) {
        return ResponseEntity.ok(accountRepository.save(account));

    }

    @SneakyThrows
    public ResponseEntity<Account> delete(Integer id) {
        return ResponseEntity.ok(accountRepository.deleteAccountById(id).orElseThrow(() -> new AccountNotFoundException("Account not found!")));
    }

    @SneakyThrows
    public ResponseEntity<Account> findAccountById(Integer id) {
        return ResponseEntity.ok(accountRepository.findAccountById(id).orElseThrow(() -> new AccountNotFoundException("Account is not found")));
    }

    @SneakyThrows
    public ResponseEntity<Account> findAccountByNameAndSurname(String clientName) {
        return ResponseEntity.ok(accountRepository.findAccountByClientName(clientName).orElseThrow(() -> new AccountNotFoundException("Account is " +
                "not found")));
    }

    @SneakyThrows
    public ResponseEntity<Account> findAccountByIban(String iban) {
        return ResponseEntity.ok(accountRepository.findAccountByIban(iban).orElseThrow(() -> new AccountNotFoundException("Account is not found")));
    }

    public ResponseEntity<Client> findClientByAccountId(Integer accountId) {
        Account account = findAccountById(accountId).getBody();
        return ResponseEntity.ok(account.getClient());
    }
}
