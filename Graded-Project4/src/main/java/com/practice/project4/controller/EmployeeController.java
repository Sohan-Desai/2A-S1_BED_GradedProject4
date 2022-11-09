package com.practice.project4.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.project4.model.Employee;
import com.practice.project4.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> listAllEmployees() {
		return employeeService.findAllEmployees();
	}

	// @GetMapping("/{id}")
	@RequestMapping(value = "/{empId}", method = GET)
	public Employee findEmployeeById(@PathVariable("empId") long id) {
		return employeeService.findEmployeeById(id);
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") long id) {
		employeeService.deleteEmployeeById(id);

		return "Deleted employee with id : " + id;
	}

//	@GetMapping("/{firstName}")
	@RequestMapping(value = "/search/{firstName}", method = GET)
	public List<Employee> listEmployeesByFirstName(@RequestParam(value = "firstName") String firstName) {
		return employeeService.findEmployeesByFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> listEmployeesCustomSortedByFirstName(Direction order) {
		return employeeService.findEmployeesCustomSortedByFirstName(order);
	}

	@GetMapping("/sortedAndPaged")
	public Page<Employee> listEmployeesCustomPagedAndCustomSortedByFirstName(int pageNum, int recordsNum,
			Direction order) {
		return employeeService.findEmployeesCustomPagedAndCustomSortedByFirstName(pageNum, recordsNum, order);
	}
}
