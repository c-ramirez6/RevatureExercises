package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();
	List<Employee> employees = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html");
		try {
			employees = dao.getEmployees(employees);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			
			for(Employee e : employees) {
				int id = e.getId();
				out.println("<p>" + e.toString() + "<a href='updateservlet?id="+ id +"'>update</a> <a href='deleteservlet?id="+ id+ "'>delete</a></p>");
			}
			out.println("<h1><a href='index.html'>Go back</a></h1>");
			employees.clear();
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		}
	}
}
