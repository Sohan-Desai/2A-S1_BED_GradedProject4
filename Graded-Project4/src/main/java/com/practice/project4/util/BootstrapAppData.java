package com.practice.project4.util;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.practice.project4.model.Employee;
import com.practice.project4.model.Role;
import com.practice.project4.model.User;
import com.practice.project4.repository.EmployeeRepository;
import com.practice.project4.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {
		List<Role> roles1 = new ArrayList<>();
		roles1.add(Role.builder().name("USER").build());

		List<Role> roles2 = new ArrayList<>();
		roles2.add(Role.builder().name("ROLE_USER").build());
		roles2.add(Role.builder().name("ROLE_ADMIN").build());

		User user1 = User.builder().username("USER").password(passwordEncoder().encode("secret"))
				.roles(roles1).build();
		this.userRepository.save(user1);

		User user2 = User.builder().username("ADMIN").password(passwordEncoder().encode("success"))
				.roles(roles2).build();
		this.userRepository.save(user2);

		Employee ramesh = Employee.builder().firstName("Ramesh").lastName("Shetty").email("ramesh@gmail.com").build();
		this.employeeRepository.save(ramesh);

		Employee krishna = Employee.builder().firstName("Krishna").lastName("Desai").email("kdesai208@gmail.com")
				.build();
		this.employeeRepository.save(krishna);

		Employee suresh = Employee.builder().firstName("Suresh").lastName("Nair").email("sureshnair@gmail.com").build();
		this.employeeRepository.save(suresh);
	}

}
