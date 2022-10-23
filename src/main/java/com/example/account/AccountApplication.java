package com.example.account;

import com.example.account.model.Customer;
import com.example.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.time.Clock;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}


	@Override
	public void run(String... args )throws Exception {
		Customer customer = customerRepository.save(new Customer("","Hüseyin", "Beller", new HashSet<>()));

		System.out.println(customer);
	}
}