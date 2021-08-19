package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset-UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			try {
				HttpSession session = request.getSession(false);
				session.invalidate();
				out.println("Logged out sucessfully");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			} catch (NullPointerException e) {
				out.println("You have not logged in");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			} catch (Exception e) {
				System.out.println("An error occured");
				e.printStackTrace();
			}
			out.println("</body>");
			out.println("</HTML>");
		}
	}
}
