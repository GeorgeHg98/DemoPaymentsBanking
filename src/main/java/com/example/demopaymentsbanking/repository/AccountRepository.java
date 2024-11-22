package com.example.demopaymentsbanking.repository;

import com.example.demopaymentsbanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Object> {
    Optional<Account> deleteAccountById(Integer id);

    Optional<Account> findAccountById(Integer id);

    Optional<Account> findAccountByClientName(String clientName);

    Optional<Account> findAccountByIban(String iban);
}
