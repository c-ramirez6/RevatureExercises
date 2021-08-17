package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset-UTF-8");
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Management </Title>");
			out.println("</Head>");
			out.println("<body>");
			String name = req.getParameter("name");
			//create a cookie
			Cookie c = new Cookie("user_name", name);
			res.addCookie(c);
			out.println("<h1>Hello " + name + " welcome</h1>");
			out.println("<h1><a href='servlet2'>Go to servlet2</h2>");
			out.println("</body>");
			out.println("</HTML>");
		}
	}
		
	
}
