package com.example.bankaccountservices.web;

import com.example.bankaccountservices.dto.BankAccountRequestDTO;
import com.example.bankaccountservices.dto.BankAccountResponseDTO;
import com.example.bankaccountservices.entities.BankAccount;
import com.example.bankaccountservices.mappers.AccountMapper;
import com.example.bankaccountservices.repositories.BankAccountRepository;
import com.example.bankaccountservices.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper)
    {this.bankAccountRepository=bankAccountRepository;
    this.accountService=accountService;
    this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("account %s not found",id)));
    }
    @PostMapping("/bankAccounnts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCretedAt()!=null)account.setCretedAt(new Date());
        if (bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}
