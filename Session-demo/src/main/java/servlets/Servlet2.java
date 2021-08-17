package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset-UTF-8");
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Management </Title>");
			out.println("</Head>");
			out.println("<body>");
			
			//get cookies
			Cookie[] cookies = req.getCookies();
			boolean flag = false;
			String name = "";
			if(cookies == null)	{
				out.println("<h1>you are a new user go to home page and submit name</h1>");
				return;
			}
			else	{
				for(Cookie c : cookies) {
					String tname = c.getName();
					if(tname.equals("user_name"))	{
						flag = true;
						name = c.getValue();
					}
				}
			}
			
			if(flag) {
				out.println("<h1>Hello " + name + " welcome back to my website</h1>");
			}
			out.println("</body>");
			out.println("</HTML>");
		}
	}

}
