package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet3 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("Welcome " + name);
		out.println("<form action='servlet4'>");
		out.println("<input type='hidden' name='uname' value='" + name + "'>");
		out.println(" <input type='submit' value='Send'>");
		out.println("</form>");
		out.close();
		
	}
}
