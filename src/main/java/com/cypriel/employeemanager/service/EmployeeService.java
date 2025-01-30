package com.cypriel.employeemanager.service;

import com.cypriel.employeemanager.exception.UserNotFoundException;
import com.cypriel.employeemanager.model.Employee;
import com.cypriel.employeemanager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	private final EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee AddEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		LOGGER.info("Created user with code: {}", employee.getEmployeeCode());
		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by ID " + id + " was not found"));
	}
}
