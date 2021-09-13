package com.revature.Spring.jpa.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spring.jpa.demo.entity.Employee;
import com.revature.Spring.jpa.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee)	{
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id)	{
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("employees/{id}")
	public void deleteEmployee(@PathVariable("id") Long id)	{
		service.deleteEmployee(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
}
