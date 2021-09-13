package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.impl.UserDAO;
import com.impl.UserDAOFactory;
import com.users.Reimbursement;
import com.users.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	UserDAO dao = UserDAOFactory.getUserDao();
	static Logger log = Logger.getRootLogger();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Reimbursement System</Title>");
			out.println("</Head>");
			out.println("<body>");
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");
			Reimbursement riem = new Reimbursement(user.getId(), Double.parseDouble(request.getParameter("amount")),
					request.getParameter("type"), request.getParameter("description"), request.getParameter("date"));
			dao.addReimbursement(riem);
			log.info(riem + "has been added");
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			out.println("<h1>Reimbursement is now pending</h1>");
			rd.include(request, response);
			out.println("</body>");
			out.println("</HTML>");
			out.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
