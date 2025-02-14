package com.example.demopaymentsbanking.mappers;

import com.example.demopaymentsbanking.dto.AccountDTO;
import com.example.demopaymentsbanking.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);
}
