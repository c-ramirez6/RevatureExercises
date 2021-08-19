package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("</Head>");
			out.println("<body>");
			String id = request.getParameter("id");
			out.println("<h1>Update employee</h1>\r\n"
					+ "  <form action='updateservlet2' method='GET'>\r\n"
					+ "    <table>\r\n"
					+ "      <tr>\r\n"
					+ "        <td>Enter name</td>\r\n"
					+ "        <td><input type='text' name='user_name' placeholder='Name' />\r\n"
					+ "        </td>\r\n"
					+ "      </tr>\r\n"
					+ "\r\n"
					+ "      <tr>\r\n"
					+ "        <td>Enter Email</td>\r\n"
					+ "        <td><input type='text' name='user_email' placeholder='Email' />\r\n"
					+ "        </td>\r\n"
					+ "      </tr>\r\n"
					+ "\r\n"
					+ "      <tr>\r\n"
					+ "        <td>Select Gender</td>\r\n"
					+ "        <td><input type='radio' name='user_gender' value='male' />Male\r\n"
					+ "        </td>\r\n"
					+ "        <td><input type='radio' name='user_gender' value='female' />Female\r\n"
					+ "        </td>\r\n"
					+ "      </tr>\r\n"
					+ "\r\n"
					+ "      <tr>\r\n"
					+ "        <td>City</td>\r\n"
					+ "        <td><select name='user_country'>\r\n"
					+ "            <option value='USA'>USA</option>\r\n"
					+ "            <option value='UK'>UK</option>\r\n"
					+ "            <option value='JPN'>JPN</option>\r\n"
					+ "          </select></td>\r\n"
					+ "      </tr>\r\n"
					+ "\r\n"
					+ "      <tr>\r\n"
					+ "        <td colspan='2'><input type='submit' value='Update'></input></td>\r\n"
					+ "\r\n"
					+ "      </tr>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    </table>\r\n"
					+ "    <input type=\"hidden\" name=\"id\" value='"+id+"'>\r\n"
					+ "    \r\n"
					+ "  </form>");
//			System.out.println("<form action='index.html'>");
//			System.out.println(" <table>");
//			System.out.println(" <tr>");
//			System.out.println(" <td>Enter name</td>");
//			System.out.println(" <td><input type='text' name='user_name' placeholder='Name' />");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//			String id = request.getParameter("id");
//			out.println(id);
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		}
	}

}
