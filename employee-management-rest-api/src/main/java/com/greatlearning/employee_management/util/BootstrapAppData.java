package com.greatlearning.employee_management.util;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.model.Role;
import com.greatlearning.employee_management.model.User;
import com.greatlearning.employee_management.repository.EmployeeRepository;
import com.greatlearning.employee_management.repository.RoleRepository;
import com.greatlearning.employee_management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {

		List<Role> roles1 = new ArrayList<>();
		roles1.add(Role.builder().name("USER").build());

		List<Role> roles2 = new ArrayList<>();
		roles2.add(Role.builder().name("USER").build());
		roles2.add(Role.builder().name("ADMIN").build());

		User user1 = User.builder().username("USER")
				.password("success").roles(roles1).build();
		this.userRepository.save(user1);

		User user2 = User.builder().username("ADMIN")
				.password("success").roles(roles1).build();
		this.userRepository.save(user2);
		
		Employee ramesh = Employee.builder().firstName("Ramesh")
				.lastName("Shetty").email("ramesh@gmail.com").build();
		this.employeeRepository.save(ramesh);
		
		Employee suresh = Employee.builder().firstName("Suresh")
				.lastName("Nair").email("sureshnair@gmail.com").build();
		this.employeeRepository.save(suresh);
	}
}
