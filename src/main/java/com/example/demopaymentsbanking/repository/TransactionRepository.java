package com.example.demopaymentsbanking.repository;

import com.example.demopaymentsbanking.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Object> {

    Optional<Transaction> findTransactionById(Integer id);

    List<Transaction> findTransactionByAccountId(Integer id);

}
