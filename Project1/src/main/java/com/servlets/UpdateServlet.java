package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{
	
	UserDAO dao = UserDAOFactory.getUserDao();
	static Logger log = Logger.getRootLogger();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("value"));
		try(PrintWriter out = response.getWriter())	{
			dao.updateReimbursement(id, status);
			if(status == 2) {
				log.info("Reimbursement no: " + id + "has been accepted");
			}
			else	{
				log.info("Reimbursement no: " + id + "has been rejected");
			}
			response.sendRedirect("adminservlet");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
