package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.connection.*;


public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Statement statement = null;
	Connection conn = null;
	
	public EmployeeDAOImpl() {
		try	{
			this.conn = ConnectionFactory.getConnection();
		}	catch(SQLException e)	{
			e.printStackTrace();
		}
	}

	@Override
	public void addEmployee(Employee emp) throws SQLException {
		String sql = "insert into employee (employee_name, employee_email, employee_gender, employee_country) values (?, ?, ?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, emp.getName());
		pre.setString(2, emp.getEmail());
		pre.setString(3, emp.getGender());
		pre.setString(4, emp.getCountry());
		pre.executeUpdate();
	}

	@Override
	public List<Employee> getEmployees(List<Employee> employees) throws SQLException {
		String sql = "select * from employee";
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		while(set.next()) {
			employees.add(new Employee(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5)));
		}
		return employees;
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		String sql = "update employee SET employee_name = ?, employee_email = ?, employee_gender = ?, employee_country = ? WHERE employee_id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, emp.getName());
		pre.setString(2, emp.getEmail());
		pre.setString(3, emp.getGender());
		pre.setString(4, emp.getCountry());
		pre.setInt(5, emp.getId());
		pre.executeUpdate();
	}

	@Override
	public void deleteEmployee(Employee emp) throws SQLException {
		String sql = "delete from employee where employee_id=" + emp.getId();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.executeUpdate(sql);
	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		String sql = "select * from employee WHERE employee_id=" + id;
		PreparedStatement pre = conn.prepareStatement(sql);

		ResultSet set = pre.executeQuery();
		while(set.next())	{
			return new Employee(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
		}
		return null;
	}
	
	

}
