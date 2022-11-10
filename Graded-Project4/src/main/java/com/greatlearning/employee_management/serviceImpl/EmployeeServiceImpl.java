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

import com.greatlearning.employee_management.model.Employee;
import com.greatlearning.employee_management.repository.EmployeeRepository;
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
		//check whether record exists
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		Employee savedEmployee = employeeRepository.findById(updatedEmployee.getId()).get();

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

	@Override
	public Page<Employee> findEmployeesCustomPagedAndCustomSortedByFirstName(int pageNum, int recordsNum,
			Direction direction) {
		Pageable pageable = PageRequest.of(pageNum, recordsNum, direction, "firstName");
		return employeeRepository.findAll(pageable);
	}

}
