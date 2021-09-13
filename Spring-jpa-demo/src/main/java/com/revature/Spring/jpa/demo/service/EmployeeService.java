package com.revature.Spring.jpa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.Spring.jpa.demo.entity.Employee;

@Service
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Long id, Employee employee);
}
