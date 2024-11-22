package com.example.demopaymentsbanking.service;

import com.example.demopaymentsbanking.entity.Employee;
import com.example.demopaymentsbanking.exceptions.EmployeeNotFoundException;
import com.example.demopaymentsbanking.repository.EmployeeRepository;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<Employee> create(Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    public ResponseEntity<List<Employee>> createEmployeeList(List<Employee> employees) {
        return ResponseEntity.ok(employeeRepository.saveAll(employees));
    }

    @SneakyThrows
    public ResponseEntity<Employee> deleteEmployeeById(Integer id) {
        return ResponseEntity.ok(employeeRepository.deleteEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found!")));
    }

    @SneakyThrows
    public ResponseEntity<Employee> findEmployeeById(Integer id) {
        return ResponseEntity.ok(employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found!")));
    }

    @SneakyThrows
    public ResponseEntity<Employee> findEmployeeByNameAndSurname(String name, String surname) {
        return ResponseEntity.ok(employeeRepository.findEmployeeByNameAndSurname(name, surname).orElseThrow(() -> new EmployeeNotFoundException("Employee not found!")));
    }
}
