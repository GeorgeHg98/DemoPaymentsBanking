package com.example.demopaymentsbanking.repository;

import com.example.demopaymentsbanking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Object> {

    Optional<Client> deleteClientById(Integer id);

    Optional<Client> findClientById(Integer id);

    Optional<Client> findClientBySurnameAndName(String surname, String name);

}
