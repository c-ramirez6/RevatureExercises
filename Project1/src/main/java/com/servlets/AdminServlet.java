package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;
import com.users.Reimbursement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

	UserDAO dao = UserDAOFactory.getUserDao();
	List<Reimbursement> reimbursements = new ArrayList<>();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println(
					"<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
					+ "        integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <table class=\"table\" style='width: 75%; margin: 0 auto'>\r\n"
					+ "        <tr>\r\n"
					+ "            <th>\r\n"
					+ "                <form action=\"adminservlet?value=5\" method=\"get\">\r\n"
					+ "                    <input type=\"hidden\" name=\"value\" value=\"5\">\r\n"
					+ "                    <input type=\"submit\" value=\"List All\" class=\"btn btn-primary\">\r\n"
					+ "                </form>\r\n"
					+ "            </th>\r\n"
					+ "            <th>\r\n"
					+ "                <form action=\"adminservlet?value=1\" method=\"get\">\r\n"
					+ "                    <input type=\"hidden\" name=\"value\" value=\"1\">\r\n"
					+ "                    <input type=\"submit\" value=\"Pending\" class=\"btn btn-primary\">\r\n"
					+ "                </form>\r\n"
					+ "            </th>\r\n"
					+ "            <th>\r\n"
					+ "                <form action=\"adminservlet?value=2\" method=\"get\">\r\n"
					+ "                    <input type=\"hidden\" name=\"value\" value=\"2\">\r\n"
					+ "                    <input type=\"submit\" value=\"Accepted\" class=\"btn btn-primary\">\r\n"
					+ "                </form>\r\n"
					+ "            </th>\r\n"
					+ "            <th>\r\n"
					+ "                <form action=\"adminservlet?value=3\" method=\"get\">\r\n"
					+ "                    <input type=\"hidden\" name=\"value\" value=\"3\">\r\n"
					+ "                    <input type=\"submit\" value=\"Rejected\" class=\"btn btn-primary\">\r\n"
					+ "                </form>\r\n"
					+ "            </th>\r\n"
					+ "            <th>\r\n"
					+ "                <a href=\"admin.jsp\">\r\n"
					+ "                    <input type=\"button\" value=\"Go Back\" class=\"btn btn-primary\">\r\n"
					+ "                </a>\r\n"
					+ "            </th>\r\n"
					+ "        </tr>\r\n"
					+ "    </table>");

			String value = request.getParameter("value");
			if (value == null || value.equals("5")) {
				reimbursements = dao.getAllReimbursements(reimbursements);
			} else {
				int listReim = Integer.parseInt(value);
				reimbursements = dao.getAllReimbursements(listReim, reimbursements);
			}
			out.println(
					"    <table class=\"table table-striped\" style='width: 75%; margin: 0 auto'>\r\n"
					+ "        <thead>\r\n"
					+ "            <tr>\r\n"
					+ "                <th scope=\"col\">Reimbursement Id</th>\r\n"
					+ "                <th scope=\"col\">User Id</th>\r\n"
					+ "                <th scope=\"col\">Amount in $</th>\r\n"
					+ "                <th scope=\"col\">Type</th>\r\n"
					+ "                <th scope=\"col\">Description</th>\r\n"
					+ "                <th scope=\"col\">Date of Expense</th>\r\n"
					+ "                <th scope=\"col\">Status</th>\r\n"
					+ "                <th colspan=\"2\" scope=\"col\">Actions</th>\r\n"
					+ "            </tr>\r\n"
					+ "        </thead>\r\n"
					+ "        <tbody>");

			for (Reimbursement r : reimbursements) {
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
						+ "                <td>\r\n"
						+ "                    <form action=\"updateservlet?value=2\" method=\"post\">\r\n"
						+ "                        <input type=\"hidden\" name=\"value\" value=\"2\">\r\n"
						+"                        <input type=\"hidden\" name=\"id\" value='"+id+"'>"
						+ "                        <input type=\"submit\" value=\"Accept\" class=\"btn btn-outline-success\">\r\n"
						+ "                    </form>\r\n"
						+ "                </td>\r\n"
						+ "                <td>\r\n"
						+ "                    <form action=\"updateservlet?value=3\" method=\"post\">\r\n"
						+ "                        <input type=\"hidden\" name=\"value\" value=\"3\">\r\n"
						+ "                        <input type=\"hidden\" name=\"id\" value='"+id+"'>"
						+ "                        <input type=\"submit\" value=\"Reject\" class=\"btn btn-outline-danger\">\r\n"
						+ "                    </form>\r\n"
						+ "                </td>\r\n"
						+ "            </tr>");

			}
			out.println(" </tbody>");
			out.println("</table");
			out.println("</body>\r\n" + "</html>");
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reimbursements.clear();
	}
}
