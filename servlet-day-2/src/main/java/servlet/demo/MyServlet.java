package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet implements Servlet{
	
	ServletConfig config = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("creating object...");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("servicing...");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<h1>Hello from servlet</h1>");
		out.print("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("destroying servlet object");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "servlet info";
	}

}
