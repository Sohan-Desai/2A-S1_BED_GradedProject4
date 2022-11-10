package com.greatlearning.employee_management.controller;

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

import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "List All Employees", notes = "This API allows you to list all employees from the employees table")
	@GetMapping
	public List<Employee> listAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@ApiOperation(value = "Find Single Employee by Id", notes = "This API allows you to find a single Employee by their Id from the employees table")
	@GetMapping("/{empId}")
	// @RequestMapping(value = "/{empId}", method = GET)
	public Employee findEmployeeById(@PathVariable("empId") long id) {
		return employeeService.findEmployeeById(id);
	}

	@ApiOperation(value = "Add Single Employee", notes = "This API allows you to add a single Employee to the employees table")
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@ApiOperation(value = "Update Employee", notes = "Employee is not fetched by their Id. Please specify correct Employee Id for updation")
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@ApiOperation(value = "Delete Employee by Id", notes = "This API allows you to delete an Employee by their Id from the employees table")
	@DeleteMapping("/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") long id) {
		employeeService.deleteEmployeeById(id);

		return "Deleted employee with id : " + id;
	}

	@ApiOperation(value = "List Any Employees with Firstname", notes = "List any employees with firstname matching entered string")
	@GetMapping("/search/{firstName}")
	// @RequestMapping(value = "/search/{firstName}", method = GET)
	public List<Employee> listEmployeesByFirstName(@RequestParam(value = "firstName") String firstName) {
		return employeeService.findEmployeesByFirstName(firstName);
	}

	@ApiOperation(value = "List Employees by Firstname Custom Sort", notes = "This API allows you to sort the employees by their firstname in both orders")
	@GetMapping("/sort")
	public List<Employee> listEmployeesCustomSortedByFirstName(Direction order) {
		return employeeService.findEmployeesCustomSortedByFirstName(order);
	}

	@ApiOperation(value = "List Employees by Firstname Custom Sort Custom Paged", notes = "This API allows you to sort the employees by their firstname in both orders with paging")
	@GetMapping("/sortedAndPaged")
	public Page<Employee> listEmployeesCustomPagedAndCustomSortedByFirstName(int pageNum, int recordsNum,
			Direction order) {
		return employeeService.findEmployeesCustomPagedAndCustomSortedByFirstName(pageNum, recordsNum, order);
	}
}
