package com.example.demopaymentsbanking.mappers;

import com.example.demopaymentsbanking.dto.BankBranchDTO;
import com.example.demopaymentsbanking.entity.BankBranch;
import org.mapstruct.factory.Mappers;

public interface BankBranchMapper {

    BankBranchMapper INSTANCE = Mappers.getMapper(BankBranchMapper.class);

    BankBranchDTO toDTO(BankBranch bankBranch);
    BankBranch toEntity(BankBranchDTO bankBranchDTO);
}
