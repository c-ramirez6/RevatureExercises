package exceptions;


class EmployeeException extends RuntimeException	{
	
}

public class ExceptionDemo {

	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		int c = 0;

		try	{
			c = a / b;	
		}	catch(ArithmeticException e)	{
			System.out.println(e.getMessage());
		}

		System.out.println(c);
		
		throw new EmployeeException();
	}

}
