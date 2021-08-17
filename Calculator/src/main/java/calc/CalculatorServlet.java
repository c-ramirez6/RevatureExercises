package calc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome to Calculator Servlet");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operation = request.getParameter("math");
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		switch(operation)	{
		case "add":	{
			out.println("<h1>Result: "+ (number1 + number2) +"</h1>");
			break;
		}
		case "subtract":	{
			out.println("<h1>Result: "+ (number1 - number2) +"</h1>");
			break;
		}
		case "multiply":	{
			out.println("<h1>Result: "+ (number1 * number2) +"</h1>");
			break;
		}
		case "divide":	{
			if(number2 != 0) {
				out.println("<h1>Result: "+ (number1 / number2) +"</h1>");
			}
			else	{
				out.println("<h1>Can not divide by 0</h1>");
			}
			break;
		}
		}
	}
	
}
