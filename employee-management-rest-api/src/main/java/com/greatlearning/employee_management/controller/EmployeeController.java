package com.greatlearning.employee_management.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	// admin
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}

	// user, admin
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public Set<Employee> findAllEmployees() {
		return this.employeeService.fetchAllEmployees();
	}

	// user, admin
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable("id") long id) {
		return this.employeeService.fetchEmployeeById(id);
	}

	// user, admin
	@GetMapping("/search/{firstName}")
	public String findEmployeeByFirstName(@PathVariable("firstName") String firstName) {
		return "find employee by first name (user & admin)";
	}

	// admin
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.updateEmployee(employee, employee.getId());
	}

	// admin
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable("id") long id) {
		this.employeeService.deleteEmployeeById(id);
	}
}
