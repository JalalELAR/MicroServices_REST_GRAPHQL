package com.example.bankaccountservices.repositories;

import com.example.bankaccountservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
