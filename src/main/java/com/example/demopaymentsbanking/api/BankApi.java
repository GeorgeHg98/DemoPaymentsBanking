package com.example.demopaymentsbanking.api;

import com.example.demopaymentsbanking.entity.Account;
import com.example.demopaymentsbanking.entity.BankBranch;
import com.example.demopaymentsbanking.entity.Client;
import com.example.demopaymentsbanking.entity.Employee;
import com.example.demopaymentsbanking.entity.Transaction;
import com.example.demopaymentsbanking.service.AccountService;
import com.example.demopaymentsbanking.service.BankBranchService;
import com.example.demopaymentsbanking.service.ClientService;
import com.example.demopaymentsbanking.service.EmployeeService;
import com.example.demopaymentsbanking.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("bank")
@RestController
@RequestMapping("/api")
public class BankApi {

    private final AccountService accountService;
    private final BankBranchService bankBranchService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final TransactionService transactionService;


    public BankApi(AccountService accountService, BankBranchService bankBranchService, ClientService clientService, EmployeeService employeeService
            , TransactionService transactionService) {
        this.accountService = accountService;
        this.bankBranchService = bankBranchService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/account/create")
    @ApiOperation(value = "Create an Account")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return accountService.create(account);
    }

    @DeleteMapping(value = "/account/delete")
    @ApiOperation(value = "Delete a banking account")
    @ApiResponse(code = 204, message = "No account with this id found")
    ResponseEntity<Account> deleteAccount(@RequestBody Integer id) {
        return accountService.delete(id);
    }

    @GetMapping(value = "/account/findById")
    @ApiOperation(value = "Get an account using the id")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Account> findAccountById(@RequestBody Integer id) {
        return accountService.findAccountById(id);
    }

    @GetMapping(value = "/account/findByClientName")
    @ApiOperation(value = "Find an account by a client's name")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Account> findAccountByName(@RequestBody String clientName) {
        return accountService.findAccountByNameAndSurname(clientName);
    }

    @GetMapping(value = "/account/findByIban")
    @ApiOperation(value = "Find an account by IBAN")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Account> findAccountByIban(@RequestBody String iban) {
        return accountService.findAccountByIban(iban);
    }

    @GetMapping(value = "/account/findClientByAccountId")
    @ApiOperation(value = "Find info about a client by using the account Id")
    @ApiResponse(code = 200, message = "Client Found!")
    ResponseEntity<Client> findClientByAccount(@RequestBody Integer accountId) {
        return accountService.findClientByAccountId(accountId);
    }

    @PostMapping(value = "/branch/create")
    @ApiOperation(value = "Create a bank branch")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<BankBranch> createBranch(@RequestBody BankBranch bankBranch) {
        return bankBranchService.create(bankBranch);
    }

    @DeleteMapping(value = "/branch/delete")
    @ApiOperation(value = "Delete a bank branch by id")
    @ApiResponse(code = 204, message = "Bank Branch deleted")
    ResponseEntity<BankBranch> deleteBranchById(@RequestBody Integer id) {
        return bankBranchService.delete(id);
    }

    @GetMapping(value = "/branch/findByName")
    @ApiOperation(value = "Find a bank branch by name")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<BankBranch> findBankBranchByName(@RequestBody String name) {
        return bankBranchService.findBankBranchByName(name);
    }

    @GetMapping(value = "/branch/findById")
    @ApiOperation(value = "Find a bank branch by id")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<BankBranch> findBankBranchById(@RequestBody Integer id) {
        return bankBranchService.findBankBranchById(id);
    }

    @PostMapping(value = "/client/create")
    @ApiOperation(value = "Create a client")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<Client> createClient(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PostMapping(value = "/client/createClientList")
    @ApiOperation(value = "Create a client List")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<List<Client>> createClientList(@RequestBody List<Client> clientList) {
        return clientService.createClientList(clientList);
    }

    @DeleteMapping(value = "/client/delete")
    @ApiOperation(value = "Delete a client by id")
    @ApiResponse(code = 204, message = "Client deleted")
    ResponseEntity<Client> deleteClientById(@RequestBody Integer id) {
        return clientService.deleteClientById(id);
    }

    @GetMapping(value = "/client/findById")
    @ApiOperation(value = "Find a client by Id")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Client> findClientById(@RequestBody Integer id){
        return clientService.findClientById(id);
    }

    @GetMapping(value = "/client/findByNameAndSurname")
    @ApiOperation(value = "Get a client by name and surname")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Client> findClientByNameAndSurname(@RequestBody String surname, String name){
        return clientService.findClientBySurnameAndName(surname, name);
    }

    @PostMapping("/employee/create")
    @ApiOperation(value = "Create an employee")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PostMapping("/employee/createEmployeeList")
    @ApiOperation(value = "Create an employee list")
    @ApiResponse(code = 201, message = "Created")
    ResponseEntity<List<Employee>> createEmployeeList(@RequestBody List<Employee> employeeList){
        return employeeService.createEmployeeList(employeeList);
    }

    @DeleteMapping("/employee/delete")
    @ApiOperation(value = "Delete an employee")
    @ApiResponse(code = 204, message = "Employee deleted")
    ResponseEntity<Employee> deleteEmployeeById(@RequestBody Integer id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employee/findById")
    @ApiOperation(value = "Find an employee by id")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Employee> findEmployeeById(@RequestBody Integer id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/employee/findByNameAndSurname")
    @ApiOperation("Find an employee by name and surname")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Employee> findEmployeeByNameAndSurname(@RequestBody String name, String surname){
        return employeeService.findEmployeeByNameAndSurname(name, surname);
    }

    @GetMapping("/transaction/findById")
    @ApiOperation("Find a transaction by id")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<Transaction> findTransactionById(@RequestBody Integer id){
        return transactionService.findTransactionById(id);
    }

    @GetMapping("/transaction/findAllByAccount")
    @ApiOperation("Find all transactions of an account")
    @ApiResponse(code = 200, message = "OK")
    ResponseEntity<List<Transaction>> findAllTransactionsByAccountId(@RequestBody Integer accountId){
        return transactionService.findAllTransactionsByAccountId(accountId);
    }

    @GetMapping("/home")
    @ApiOperation("Test endpoint to see if the app returns a basic string")
    @ApiResponse(code = 200, message = "OK")
    String home(){
        return "Home";
    }
}
