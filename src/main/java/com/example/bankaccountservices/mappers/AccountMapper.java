package com.example.bankaccountservices.mappers;

import com.example.bankaccountservices.dto.BankAccountRequestDTO;
import com.example.bankaccountservices.dto.BankAccountResponseDTO;
import com.example.bankaccountservices.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
    BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
    BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
    return bankAccountResponseDTO;
}
    public BankAccount toBankAccount(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount=new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCretedAt(new Date());
        BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        return bankAccount;
    }
    public BankAccount toBankAccount2(String id,BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount=new BankAccount();
        bankAccount.setId(id);
        bankAccount.setCretedAt(new Date());
        BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        return bankAccount;
    }
}
