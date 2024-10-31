package com.example.bankaccountservices.service;

import com.example.bankaccountservices.dto.BankAccountRequestDTO;
import com.example.bankaccountservices.dto.BankAccountResponseDTO;
import com.example.bankaccountservices.entities.BankAccount;
import com.example.bankaccountservices.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);
}
