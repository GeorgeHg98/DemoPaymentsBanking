package com.example.demopaymentsbanking.repository;

import com.example.demopaymentsbanking.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Object> {

    Optional<Employee> deleteEmployeeById(Integer id);

    Optional<Employee> findEmployeeById(Integer id);

    Optional<Employee> findEmployeeByNameAndSurname(String name, String surname);
}
