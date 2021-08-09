package database;

public class Admin extends User{

	public Admin(int id, String name, String username, String password) {
		super(id, name, username, password);
		System.out.println("I am an admin");
	}
	
	public void listChoices()	{
		System.out.println("1 - Approve accounts");
		System.out.println("2 - View customers accounts");
		System.out.println("3 - Quit");
	}

}
