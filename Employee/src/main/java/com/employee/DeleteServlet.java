package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			int id = Integer.parseInt(request.getParameter("id"));
			Employee e = dao.getEmployee(id);
			dao.deleteEmployee(e);
			out.println("Deleted employee");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

