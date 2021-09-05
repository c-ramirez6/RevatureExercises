package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;
import com.users.Reimbursement;
import com.users.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListServlet extends HttpServlet{
	UserDAO dao = UserDAOFactory.getUserDao();
	List<Reimbursement> reimbursements = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException	{
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		try(PrintWriter out = response.getWriter())	{
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <form action=\"listservlet?value=1\" method=\"GET\">\r\n"
					+ "        <input type=\"hidden\" name=\"value\" value=\"1\"/>\r\n"
					+ "        <input type=\"submit\" value=\"list all\">\r\n"
					+ "    </form>\r\n"
					+ "    <form action=\"listservlet?value=2\" method=\"GET\">\r\n"
					+ "        <input type=\"hidden\" name=\"value\" value=\"2\"/>\r\n"
					+ "        <input type=\"submit\" value=\"lodging\">\r\n"
					+ "    </form>\r\n"
					+ "    <form action=\"listservlet?value=3\" method=\"GET\">\r\n"
					+ "        <input type=\"hidden\" name=\"value\" value=\"3\"/>\r\n"
					+ "        <input type=\"submit\" value=\"travel\">\r\n"
					+ "    </form>\r\n"
					+ "    <form action=\"listservlet?value=4\" method=\"GET\">\r\n"
					+ "        <input type=\"hidden\" name=\"value\" value=\"4\"/>\r\n"
					+ "        <input type=\"submit\" value=\"food\">\r\n"
					+ "    </form>\r\n"
					+ "    <form action=\"listservlet?value=5\" method=\"GET\">\r\n"
					+ "        <input type=\"hidden\" name=\"value\" value=\"5\"/>\r\n"
					+ "        <input type=\"submit\" value=\"other\">\r\n"
					+ "    </form>");
			
			String value = request.getParameter("value");
			if(value == null || value.equals("1")) {
				reimbursements = dao.getReimbursements(user.getId(), reimbursements);
			}
			else	{
				int listReim = Integer.parseInt(value);
				reimbursements = dao.getReimbursements(user.getId(), listReim, reimbursements);
			}
			out.println("<table>\r\n"
					+ "        <thead>\r\n"
					+ "            <tr>\r\n"
					+ "                <td>id</td>\r\n"
					+ "                <td>user id</td>\r\n"
					+ "                <td>amount</td>\r\n"
					+ "                <td>type</td>\r\n"
					+ "                <td>desc</td>\r\n"
					+ "                <td>date</td>\r\n"
					+ "                <td>status</td>\r\n"
					+ "            </tr>\r\n"
					+ "        </thead>\r\n"
					+ "        <tbody>");

			for(Reimbursement r : reimbursements) {
				int id = r.getId();
				int usersId = r.getUsers_id();
				double amount = r.getAmount();
				String type = r.getType();
				String desc = r.getDesc();
				String date = r.getDate();
				String status = r.getStatus();
				
				out.println("<tr>\r\n"
						+ "                <td>"+id+"</td>\r\n"
						+ "                <td>"+usersId+"</td>\r\n"
						+ "                <td>"+amount+"</td>\r\n"
						+ "                <td>"+type+"</td>\r\n"
						+ "                <td>"+desc+"</td>\r\n"
						+ "                <td>"+date+"</td>\r\n"
						+ "                <td>"+status+"</td>\r\n"
						+ "            </tr>");
				
			}
			out.println(" </tbody>");
			out.println("</table");
			out.println("</body>\r\n"
					+ "</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
