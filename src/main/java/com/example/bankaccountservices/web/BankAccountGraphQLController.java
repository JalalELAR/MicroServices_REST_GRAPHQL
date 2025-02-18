package com.example.bankaccountservices.web;

import com.example.bankaccountservices.dto.BankAccountRequestDTO;
import com.example.bankaccountservices.dto.BankAccountResponseDTO;
import com.example.bankaccountservices.entities.BankAccount;
import com.example.bankaccountservices.entities.Customer;
import com.example.bankaccountservices.repositories.BankAccountRepository;
import com.example.bankaccountservices.repositories.CustomerRepository;
import com.example.bankaccountservices.service.AccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
    return accountService.addAccount(bankAccount);
}
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
/*record BankAccountDTO(Double balance , String balance , String type , String currency){
}*/
