package com.demo.data.rest;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.Employee;
import com.demo.repositories.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.demo.repositories" })
@EntityScan(basePackages = { "com.demo.entity" })
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Bean
	CommandLineRunner startup(EmployeeRepository employeeRepository) {

		return (args) -> {
			System.out.println("=============== SPRING DATA REST =================");

			employeeRepository.save(new Employee("KARTHIK", "CANADA", new BigDecimal("100")));
			employeeRepository.save(new Employee("BASHYAM", "CANADA", new BigDecimal("100")));
		};

	}

}
