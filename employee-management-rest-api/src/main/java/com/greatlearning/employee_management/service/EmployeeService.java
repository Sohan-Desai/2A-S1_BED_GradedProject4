package com.greatlearning.employee_management.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	public Set<Employee> fetchAllEmployees() {
		return new HashSet<>(this.employeeRepository.findAll());
	}

	public Employee fetchEmployeeById(long id) {
		return this.employeeRepository.findById(id).orElseThrow();
	}

	public Employee updateEmployee(Employee updatedEmployee, long id) {

		Employee savedEmployee = employeeRepository.findById(id).get();

		savedEmployee.setFirstName(updatedEmployee.getFirstName());
		savedEmployee.setLastName(updatedEmployee.getLastName());
		savedEmployee.setEmail(updatedEmployee.getEmail());

		return this.employeeRepository.save(savedEmployee);
	}

	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
}
