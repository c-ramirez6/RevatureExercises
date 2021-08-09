package database;

public class Customer extends User{
	public Customer(int id, String name, String username, String password) {
		super(id, name, username, password);
		System.out.println("I am an Customer");
	}
	
	@Override
	public void listChoices() {
		System.out.println("1 - Create an account");
		System.out.println("2 - View balance of account");
		System.out.println("3 - Make a deposit");
		System.out.println("4 - Make a withdrawl");
		System.out.println("5 - Transfer money between accounts");
		System.out.println("6 - Quit");
	}
	
	
	
}
