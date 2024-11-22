package com.example.demopaymentsbanking.mappers;

import com.example.demopaymentsbanking.dto.ClientDTO;
import com.example.demopaymentsbanking.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
}

