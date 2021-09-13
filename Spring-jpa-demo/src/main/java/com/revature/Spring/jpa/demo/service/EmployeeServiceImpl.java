package com.revature.Spring.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Spring.jpa.demo.entity.Employee;
import com.revature.Spring.jpa.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

		@Autowired
		private EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = repo.findById(id);
		if(!emp.isPresent())	{
			
		}
		return emp.get();
		
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employeeDB = repo.findById(id).get();
		employeeDB.setName(employee.getName());
		employeeDB.setEmail(employee.getEmail());
		return repo.save(employeeDB);
		
	}

}
