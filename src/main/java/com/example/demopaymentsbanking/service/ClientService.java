package com.example.demopaymentsbanking.service;

import com.example.demopaymentsbanking.entity.Client;
import com.example.demopaymentsbanking.exceptions.ClientNotFoundException;
import com.example.demopaymentsbanking.repository.ClientRepository;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Client> create(Client client) {
        return ResponseEntity.ok(clientRepository.save(client));
    }

    public ResponseEntity<List<Client>> createClientList(List<Client> clients) {
        return ResponseEntity.ok(clientRepository.saveAll(clients));
    }

    @SneakyThrows
    public ResponseEntity<Client> deleteClientById(Integer id) {
        return ResponseEntity.ok(clientRepository.deleteClientById(id).orElseThrow(() -> new ClientNotFoundException("Client not found!")));
    }

    @SneakyThrows
    public ResponseEntity<Client> findClientById(Integer id) {
        return ResponseEntity.ok(clientRepository.findClientById(id).orElseThrow(() -> new ClientNotFoundException("Client not found!")));
    }

    @SneakyThrows
    public ResponseEntity<Client> findClientBySurnameAndName(String surname, String name) {
        return ResponseEntity.ok(clientRepository.findClientBySurnameAndName(surname, name).orElseThrow(() -> new ClientNotFoundException("Client not found!")));
    }
}
