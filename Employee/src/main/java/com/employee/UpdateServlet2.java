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

public class UpdateServlet2 extends HttpServlet{
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			
			String tid = request.getParameter("id");
			System.out.println(tid);
			int id = Integer.parseInt(tid);
			Employee emp = dao.getEmployee(id);
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("email"));
//			System.out.println(request.getParameter("gender"));
//			System.out.println(request.getParameter("country"));
			emp = new Employee(id, request.getParameter("user_name"), request.getParameter("user_email"), request.getParameter("user_gender"), request.getParameter("user_country"));
			dao.updateEmployee(emp);
			out.println("employee has been updated");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
