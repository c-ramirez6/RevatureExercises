package database;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String command = "";
		UserDAO userdao = UserDAOFactory.getUserDao();
		System.out.println("Welcome to the banking application");
		System.out.println("What would you like to do? ");
		System.out.println("1 - Login");
		System.out.println("2 - Register a new account");
		command = in.nextLine();
		if(command.equals("1"))	{
			//Ask for username and password
			//Make customer object using database
			//List customer Choices
			User user = new User();
			System.out.println("Enter username: ");
			user.setUsername(in.nextLine());
			System.out.println("Enter password: ");
			user.setPassword(in.nextLine());
			try {
				user = userdao.getUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user.getId() == 0)	{
				System.out.println("Username or password was incorrect");
			}
			else	{
				user.listChoices();
				System.out.println(user);
			}
			if(user instanceof Admin)	{
				Admin boss = (Admin) user;
				boss.listChoices();
			}
		}
		else if(command.equals("2"))	{
			//Ask for name, username, and password
			//Insert into database new user
			//Make customer object
			//List Customer Choices
			User user = new User();
			System.out.println("Enter you name: ");
			user.setName(in.nextLine());
			System.out.println("Enter username: ");
			user.setUsername(in.nextLine());
			System.out.println("Enter password: ");
			user.setPassword(in.nextLine());
			try {
				user = userdao.registerAccount(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.listChoices();
		}
	}

}
