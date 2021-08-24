package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{
	
	EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();
	List<Employee> employees = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException	{
		
		
		response.setContentType("text/html");
		try {
			employees = dao.getEmployees(employees);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Login</Title>");
			out.println("  <style>\r\n"
					+ "    table{\r\n"
					+ "      padding: 20px;\r\n"
					+ "      width: 50%;\r\n"
					+ "      margin: 0 auto;\r\n"
					+ "      border: 3px solid grey;\r\n"
					+ "      border-collapse: collapse;\r\n"
					+ "    }\r\n"
					+ "    td{\r\n"
					+ "      padding: 8px;\r\n"
					+ "    }\r\n"
					+ "  </style>");
			out.println("</Head>");
			out.println("<body>");
			
			out.println("<table border='1'>\r\n"
					+ "\r\n"
					+ "  <thead>\r\n"
					+ "    <td>Employee id</td>\r\n"
					+ "    <td>Employee name</td>\r\n"
					+ "    <td>Employee email</td>\r\n"
					+ "    <td>Employee gender</td>\r\n"
					+ "    <td>Employee country</td>\r\n"
					+ "    <td colspan=\"2\">Options</td>\r\n"
					+ "  </thead>");

			for(Employee e : employees) {
				int id = e.getId();
				String name = e.getName();
				String email = e.getEmail();
				String gender = e.getGender();
				String country = e.getCountry();
				
				out.println(" <tr>\r\n"
						+ "    <td>"+id+"</td>\r\n"
						+ "    <td>"+name+"</td>\r\n"
						+ "    <td>"+email+"</td>\r\n"
						+ "    <td>"+gender+"</td>\r\n"
						+ "    <td>"+country+"</td>\r\n"
						+ "    <td><a href='updateservlet?id="+ id +"&name=" +name+"&email="+email+"&gender="+gender+"&country="+country+"'>update</a></td>\r\n"
						+ "    <td><a href='deleteservlet?id="+ id+"'>delete</a></td>\r\n"
						+ "  </tr>");
				
				//out.println("<p>" + e.toString() + "<a href='updateservlet?id="+ id +"&name=" +name+"&email="+email+"&gender="+gender+"&country="+country+"'>update</a> <a href='deleteservlet?id="+ id+ "'>delete</a></p>");
			}
			out.println("</table");
			out.println("<h1><a href='index.html'>Go back</a></h1>");
			employees.clear();
			out.println("</body>");
			out.println("</HTML>");
			out.close();
		}
		
		
		
		
		
//		response.setContentType("text/html");
//		try {
//			employees = dao.getEmployees(employees);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try(PrintWriter out = response.getWriter()){
//			
//			out.println("<!DOCTYPE html>\r\n"
//					+ "<html lang=\"en\">\r\n"
//					+ "<head>\r\n"
//					+ "    <meta charset=\"UTF-8\">\r\n"
//					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
//					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
//					+ "    <title>Document</title>\r\n"
//					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
//					+ "    integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n"
//					+ "    <style>\r\n"
//					+ "         .wrapper{\r\n"
//					+ "        width: 50%;\r\n"
//					+ "        margin: 0 auto;\r\n"
//					+ "            margin-top: 10px;\r\n"
//					+ "        border: 10px solid grey;\r\n"
//					+ "        border-radius: 10px;\r\n"
//					+ "        padding: 25px 25px 25px 25px;\r\n"
//					+ "      }\r\n"
//					+ "\r\n"
//					+ "      h1{\r\n"
//					+ "        width: 50%;\r\n"
//					+ "        margin:0 auto;\r\n"
//					+ "        padding-bottom: 20px;\r\n"
//					+ "      }\r\n"
//					+ "      \r\n"
//					+ "    </style>\r\n"
//					+ "</head>");
//			
//			out.println("<body>");
//			out.println(" <div class=\"wrapper\">");
//			out.println(" <h1>Employees</h1>");
//			out.println("<table class=\"table table-striped table-hover\">");
//			
//			for(Employee e : employees) {
//			int id = e.getId();
//			out.println("<tr>");
//			out.println("<td colspan=\"2\">\r\n"
//					+ "                <p>" + e.toString() + "</p>\r\n"
//					+ "            </td>");
//			out.println("<td class=\"btn-group\" role=\"group\">");
//			out.println(" <form action='updateservlet?id="+id+"'>");
//			out.println("<button type='submit' class='btn btn-warning' style='margin-right: 10%;'>Update Employee</button>\r\n"
//					+ "                </form>");
//			out.println(" <form action='deleteservlet?id="+id+"'>\r\n"
//					+ "                    <button type='submit' class='btn btn-danger'  style='margin-right: 10%;'>Delete Employee</button>\r\n"
//					+ "                </form>");
//			out.println("</td>");
//			out.println(" </tr>");
//		}
//			employees.clear();
//			out.println("</table>");
//			out.println("</div>");
//			out.println("</body>");
//			out.println("</HTML>");
//			out.close();
//		}
	}
}
