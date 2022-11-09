package com.greatlearning.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EmployeeManagementRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementRestApiApplication.class, args);
	}

}
