package com.example.bankaccountservices.service;

import com.example.bankaccountservices.dto.BankAccountRequestDTO;
import com.example.bankaccountservices.dto.BankAccountResponseDTO;
import com.example.bankaccountservices.entities.BankAccount;
import com.example.bankaccountservices.mappers.AccountMapper;
import com.example.bankaccountservices.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=accountMapper.toBankAccount(bankAccountRequestDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount) ;
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=accountMapper.toBankAccount2(id,bankAccountRequestDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount) ;
        return bankAccountResponseDTO;
    }
}
