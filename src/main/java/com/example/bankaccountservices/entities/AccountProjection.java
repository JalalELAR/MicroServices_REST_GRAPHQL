package com.example.bankaccountservices.entities;

import com.example.bankaccountservices.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1 ")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
