package com.practice.project4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.practice.project4.model.Employee;
import com.practice.project4.repository.EmployeeRepository;
import com.practice.project4.service.EmployeeService;

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
		return employeeRepository.findById(id).get();
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
