package com.example.bankaccountservices;

import com.example.bankaccountservices.entities.BankAccount;
import com.example.bankaccountservices.entities.Customer;
import com.example.bankaccountservices.enums.AccountType;
import com.example.bankaccountservices.repositories.BankAccountRepository;
import com.example.bankaccountservices.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository,CustomerRepository customerRepository) {
		return args -> {
			Stream.of("mohamed","yassine","hanane","imane").forEach(c->{
							Customer customer=Customer.builder()
							.name(c)
							.build();
			customerRepository.save(customer);
		});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 1; i <= 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(1000 + Math.random() * 90000)
							.cretedAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});

		};
	}
} 
