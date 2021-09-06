package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{
	
	UserDAO dao = UserDAOFactory.getUserDao();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("value"));
		try(PrintWriter out = response.getWriter())	{
			dao.updateReimbursement(id, status);
			response.sendRedirect("adminservlet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
