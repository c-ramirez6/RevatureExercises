package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome to register servlet");
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String gender = request.getParameter("user_gender");
		String city = request.getParameter("user_city");
		String terms = request.getParameter("terms");
		if (terms.equals("checked")) {
			out.println("<h1>Name " + name + "</h1>");
			out.println("<h1>Email " + email + "</h1>");
			out.println("<h1>Password " + password + "</h1>");
			out.println("<h1>Gender " + gender + "</h1>");
			out.println("<h1>City " + city + "</h1>");
		} else {
			out.println("<h2>You have not accepted terms and agreements</h2>");
		}
	}
}
