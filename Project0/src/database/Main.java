package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		if (command.equals("1")) {
			// Ask for username and password
			// Make customer object using database
			// List customer Choices
			User user = new User();
			System.out.println("Enter username: ");
			user.setUsername(in.nextLine());
			System.out.println("Enter password: ");
			user.setPassword(in.nextLine());
			try {
				int type = userdao.getUser(user);
				List<Account> accounts = new ArrayList<>();
				if (type == 2) {
					Customer cust = new Customer(user.getId(), user.getName(), user.getUsername(), user.getPassword());
					CustomerDAO custdao = CustomerDAOFactory.getCustomerDao();
					do {
						cust.listChoices();
						command = in.nextLine();
						switch (command) {
						case "1":	{
							System.out.println("Enter the name of the new account: ");
							String name = in.nextLine();
							System.out.println("Enter initial amount in the account: ");
							int amount = Integer.parseInt(in.nextLine());
							Account newAccount = new Account(amount, name);
							custdao.addAccount(newAccount, cust);
							break;
						}
						case "2": {
							accounts = custdao.viewBalance(cust);
							for (Account account : accounts) {
								System.out.println(account);
							}
							break;
						}
						case "3": {
							System.out.println("Enter account you wish to deposit into: ");
							accounts = custdao.viewBalance(cust);
							int count = 1;
							for (Account account : accounts) {
								System.out.println(count + " - " + account);
								count++;
							}
							try	{
								int choice = Integer.parseInt(in.nextLine());
								System.out.println("Enter amount to deposit: ");
								int amount = Integer.parseInt(in.nextLine());
								
									custdao.deposit(cust, amount, accounts.get(choice - 1));
							}
							catch(NumberFormatException e) {
								System.out.println("Please enter a valid number");
							}
							catch(IndexOutOfBoundsException e) {
								System.out.println("No account found by that number");
							}
							
							break;
						}
						case "4":	{
							System.out.println("Enter account you wish to withdraw from: ");
							accounts = custdao.viewBalance(cust);
							int count = 1;
							for (Account account : accounts) {
								System.out.println(count + " - " + account);
								count++;
							}
							int choice = Integer.parseInt(in.nextLine());
							System.out.println("Enter amount to withdraw: ");
							int amount = Integer.parseInt(in.nextLine());
							custdao.withdraw(cust, amount, accounts.get(choice - 1));
							break;
						}
						case "5":	{
							System.out.println("Enter account you wish to transfer from: ");
							accounts = custdao.viewBalance(cust);
							int count = 1;
							for (Account account : accounts) {
								System.out.println(count + " - " + account);
								count++;
							}
							int fromAccount = Integer.parseInt(in.nextLine());
							System.out.println("Enter account you wish to transfer to: ");
							int toAccount = Integer.parseInt(in.nextLine());
							System.out.println("Enter the amount you wish to transfer");
							int amount = Integer.parseInt(in.nextLine());
							custdao.transferMoney(cust, accounts.get(toAccount - 1), accounts.get(fromAccount - 1), amount);
							break;
						}
						}
					} while (!command.equals("6"));
				} else if (type == 1) {
					Admin admin = new Admin(user.getId(), user.getName(), user.getUsername(), user.getPassword());
					AdminDAO admindao = AdminDAOFactory.getAdminDao();
					do	{
						admin.listChoices();
						command= in.nextLine();
						switch(command)	{
						case "1":	{
							accounts = admindao.getAllPendingAccounts();
							System.out.println("Select an account to approve or enter 0 to escape");
							int choice = Integer.parseInt(in.nextLine());
							if(choice == 0)	{
								break;
							}
							admindao.approveAccounts(accounts.get(choice-1));
							break;
						}
						case "2":	{
							admindao.listTransactions();
							break;
						}
						}
					}while(!command.equals("3"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user.getId() == 0) {
				System.out.println("Username or password was incorrect");
			}

		} else if (command.equals("2")) {
			// Ask for name, username, and password
			// Insert into database new user
			// Make customer object
			// List Customer Choices
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
