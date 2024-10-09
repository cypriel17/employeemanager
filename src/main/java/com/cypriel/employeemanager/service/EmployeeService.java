package com.cypriel.employeemanager.service;

import com.cypriel.employeemanager.exception.UserNotFoundException;
import com.cypriel.employeemanager.model.Employee;
import com.cypriel.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee updateEmployee){
        return employeeRepository.save(updateEmployee);
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " is not found!"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
