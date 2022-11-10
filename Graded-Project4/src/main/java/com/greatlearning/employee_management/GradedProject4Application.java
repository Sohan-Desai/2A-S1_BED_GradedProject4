package com.greatlearning.employee_management;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.greatlearning.employee_management.serviceImpl.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class GradedProject4Application implements CommandLineRunner {

	@Autowired
	EmployeeServiceImpl empServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(GradedProject4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Fetch Employees custom sorted by their firstName -> {}",
				empServiceImpl.findEmployeesCustomSortedByFirstName(ASC));
		log.info("Fetch Employees custom sorted and custom paged by their firstName -> {}", empServiceImpl
				.findEmployeesCustomPagedAndCustomSortedByFirstName(0, 2, DESC).get().collect(Collectors.toList()));
	}

}
