package runner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import accounts.Account;
import factories.AdminDAOFactory;
import factories.CustomerDAOFactory;
import factories.UserDAOFactory;
import interfaces.AdminDAO;
import interfaces.CustomerDAO;
import interfaces.UserDAO;
import users.Admin;
import users.Customer;
import users.User;

public class Runner {

	Scanner in = new Scanner(System.in);
	String command = "";
	UserDAO userdao = UserDAOFactory.getUserDao();
	  static Logger log = Logger.getLogger(Runner.class.getName());  

	public Runner() {

	}

	public void run() {
		do {
			System.out.println("Welcome to the banking application");
			System.out.println("What would you like to do? ");
			System.out.println("1 - Login");
			System.out.println("2 - Register a new account");
			System.out.println("3 - Quit application");

			command = in.nextLine();
			if (command.equals("1")) {
				userLoop();
			} else if (command.equals("2")) {
				registerUser();
				System.out.println("Account Created");
				System.out.println("Please login");
				userLoop();
			}
		} while (!command.equals("3"));
	}

	public void userLoop() {
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
					case "1": {
						System.out.println("Enter the name of the new account: ");
						String name = in.nextLine();
						System.out.println("Enter initial amount in the account: ");
						int amount = Integer.parseInt(in.nextLine());
						Account newAccount = new Account(amount, name);
						custdao.addAccount(newAccount, cust);
						log.info("Account creation called");  
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
						try {
							int choice = Integer.parseInt(in.nextLine());
							System.out.println("Enter amount to deposit: ");
							int amount = Integer.parseInt(in.nextLine());

							custdao.deposit(cust, amount, accounts.get(choice - 1));
						} catch (NumberFormatException e) {
							System.out.println("Please enter a valid number");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("No account found by that number");
						}
						log.info("Deposit called");  
						break;
					}
					case "4": {
						System.out.println("Enter account you wish to withdraw from: ");
						accounts = custdao.viewBalance(cust);
						int count = 1;
						for (Account account : accounts) {
							System.out.println(count + " - " + account);
							count++;
						}
						try {
							int choice = Integer.parseInt(in.nextLine());
							System.out.println("Enter amount to withdraw: ");
							int amount = Integer.parseInt(in.nextLine());
							custdao.withdraw(cust, amount, accounts.get(choice - 1));
						} catch (NumberFormatException e) {
							System.out.println("Please enter a valid number");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("No account found by that number");
						}
						log.info("Withdraw called");  
						break;
					}
					case "5": {
						System.out.println("Enter account you wish to transfer from: ");
						accounts = custdao.viewBalance(cust);
						int count = 1;
						for (Account account : accounts) {
							System.out.println(count + " - " + account);
							count++;
						}
						try {
							int fromAccount = Integer.parseInt(in.nextLine());
							System.out.println("Enter account you wish to transfer to: ");
							int toAccount = Integer.parseInt(in.nextLine());
							System.out.println("Enter the amount you wish to transfer");
							int amount = Integer.parseInt(in.nextLine());
							custdao.transferMoney(cust, accounts.get(toAccount - 1), accounts.get(fromAccount - 1),
									amount);
						} catch (NumberFormatException e) {
							System.out.println("Please enter a valid number");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("No account found by that number");
						}
						log.info("Transfer called");  
						break;
					}
					}
				} while (!command.equals("6"));
			} else if (type == 1) {
				Admin admin = new Admin(user.getId(), user.getName(), user.getUsername(), user.getPassword());
				AdminDAO admindao = AdminDAOFactory.getAdminDao();
				do {
					admin.listChoices();
					command = in.nextLine();
					switch (command) {
					case "1": {
						try {
							accounts = admindao.getAllPendingAccounts();
							if (accounts.size() == 0) {
								System.out.println("No accounts pending");
								break;
							}
							System.out.println("Select an account to approve or enter 0 to escape");
							int choice = Integer.parseInt(in.nextLine());
							if (choice == 0) {
								break;
							}
							admindao.approveAccounts(accounts.get(choice - 1));
						} catch (NumberFormatException e) {
							System.out.println("Please enter a valid number");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("No account found by that number");
						}
						log.info("Account approval called");  
						break;
					}
					case "2": {
						try {
							accounts = admindao.getAllPendingAccounts();
							if (accounts.size() == 0) {
								System.out.println("No accounts pending");
								break;
							}
							System.out.println("Select an account to decline or enter 0 to escape");
							int choice = Integer.parseInt(in.nextLine());
							if (choice == 0) {
								break;
							}
							admindao.declineAccounts(accounts.get(choice - 1));
						} catch (NumberFormatException e) {
							System.out.println("Please enter a valid number");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("No account found by that number");
						}
						log.info("Account denyed called");  
						break;
					}
					case "3": {
						admindao.listTransactions();
						break;
					}
					}
				} while (!command.equals("4"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user.getId() == 0) {
			System.out.println("Username or password was incorrect");
		}
	}

	public void registerUser() {
		User user = new User();
		System.out.println("Enter your name: ");
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
		log.info("User registration called");  

	}
}
