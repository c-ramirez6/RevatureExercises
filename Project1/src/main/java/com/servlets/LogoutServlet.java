package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	static Logger log = Logger.getRootLogger();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		response.setContentType("text/html; charset-UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Reimbursement System</Title>");
			out.println("</Head>");
			out.println("<body>");
			try {
				HttpSession session = request.getSession(false);
				log.info(session.getAttribute("user") + " logged out");
				session.invalidate();
				out.println("Logged out sucessfully");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}  catch (Exception e) {
				System.out.println("An error occured");
				e.printStackTrace();
			}
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		}
	}

}
