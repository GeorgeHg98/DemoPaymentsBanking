package com.example.demopaymentsbanking.repository;

import com.example.demopaymentsbanking.entity.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch, Object> {

    Optional<BankBranch> deleteBankBranchById(Integer id);

    Optional<BankBranch> findBankBranchByName(String name);

    Optional<BankBranch> findBankBranchById(Integer id);
}
