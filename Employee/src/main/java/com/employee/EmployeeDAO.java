package com.employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	public void addEmployee(Employee emp) throws SQLException;
	
	public List<Employee> getEmployees(List<Employee> employees) throws SQLException;
	
	public void updateEmployee(Employee emp) throws SQLException;
	
	public void deleteEmployee(Employee emp) throws SQLException;
	
	public Employee getEmployee(int id) throws SQLException;
	
}
