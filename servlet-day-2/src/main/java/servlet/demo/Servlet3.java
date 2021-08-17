package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet3 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("this is Get method of my servlet");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h1>Get method call</h1>");
		out.print(new Date().toString());
	}
}
