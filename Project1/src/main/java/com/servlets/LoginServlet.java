package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;
import com.users.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	
	UserDAO dao = UserDAOFactory.getUserDao();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter())	{
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			User user = dao.getUser(request.getParameter("username"), request.getParameter("password"));
			RequestDispatcher rd;
			if(user == null)	{
				out.println("Invalid Login Credentials");
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			rd = request.getRequestDispatcher("user.jsp");
			out.println("<h1>Welcome "+user.getUsername()+"</h1>");
			rd.include(request, response);
			
			out.println("</body>");
			out.println("</HTML>");
			out.close();
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
