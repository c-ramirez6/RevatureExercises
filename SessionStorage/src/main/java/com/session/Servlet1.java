package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String value = request.getParameter("name");
		
		out.println("Welcome " + value);
		out.println("<h1><a href='servlet2?value=" + value + "'>Click Here</a></h1>");
		out.close();
	}
}
