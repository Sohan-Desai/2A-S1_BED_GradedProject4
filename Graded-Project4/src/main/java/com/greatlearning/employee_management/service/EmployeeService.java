package com.greatlearning.employee_management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employee_management.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();

	Employee findEmployeeById(long id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(long id);

	List<Employee> findEmployeesByFirstName(String firstName);

	List<Employee> findEmployeesCustomSortedByFirstName(Direction direction);

	Page<Employee> findEmployeesCustomPagedAndCustomSortedByFirstName(int pageNum, int recordsNum, Direction direction);

}
