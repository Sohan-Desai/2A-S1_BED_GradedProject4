package com.greatlearning.employee_management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employee_management.dao.EmployeeRepository;
import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {
		// check whether record exists
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee with id - " + id);
		}
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		// check whether record exists
		Optional<Employee> result = employeeRepository.findById(updatedEmployee.getId());
		Employee savedEmployee = null;

		if (result.isPresent()) {
			savedEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee with id - " + updatedEmployee.getId());
		}
		savedEmployee.setFirstName(updatedEmployee.getFirstName());
		savedEmployee.setLastName(updatedEmployee.getLastName());
		savedEmployee.setEmail(updatedEmployee.getEmail());

		return employeeRepository.save(savedEmployee);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findEmployeesByFirstName(String firstName) {
		return employeeRepository.findAllByFirstName(firstName);
	}

	@Override
	public List<Employee> findEmployeesCustomSortedByFirstName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	/*
	 * return a custom page of employees sorted by their firstname page-number, no.
	 * of employees in each page and sorting order to be specified by the user
	 */
	@Override
	public Page<Employee> findEmployeesCustomPagedAndCustomSortedByFirstName(int pageNum, int recordsNum, Direction direction) {
		Pageable pageable = PageRequest.of(pageNum, recordsNum, direction, "firstName");
		return employeeRepository.findAll(pageable);
	}

}
