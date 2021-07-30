package calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean calc = true;
		do {
			System.out.println("Enter first number: ");
			int firstNum = in.nextInt();
			System.out.println("Enter Second number: ");
			int secondNum = in.nextInt();
			
			System.out.println("Select choice (Enter the corresponding number)");
			System.out.println("1 - Add");
			System.out.println("2 - Subtract");
			System.out.println("3 - Multiply");
			System.out.println("4 - Divide");
			
			int choice = in.nextInt();
			System.out.println(calculate(choice, firstNum, secondNum));
			System.out.println("Would you like to continue? y/n?");
			
			if(in.next().equals("n"))	{
				calc = !calc;
			}
		}
		while(calc);
	}
	
	public static int calculate(int choice, int firstNum, int secondNum)	{
		if(choice == 1) {
			return firstNum + secondNum;
		}
		else if(choice == 2) {
			return firstNum - secondNum;
		}
		else if(choice == 3)	{
			return firstNum * secondNum;
		}
		else	{
			if(secondNum == 0) {
				System.out.println("Can not divide by zero");
				return -1;
			}
		}
		return firstNum/secondNum;
	}

}
