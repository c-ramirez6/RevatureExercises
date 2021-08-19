package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String gender = request.getParameter("user_gender");
			String country = request.getParameter("user_country");
			Employee emp = new Employee(name, email, gender, country);
			dao.addEmployee(emp);
			out.println("Employee added");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
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
