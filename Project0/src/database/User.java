package database;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	
	public User()	{
		
	}
	
	public User(int id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public void listChoices() {
		System.out.println("1 - Create an account");
		System.out.println("2 - View balance of account");
		System.out.println("3 - Make a deposit");
		System.out.println("4 - Make a withdrawl");
		System.out.println("5 - Transfer money between accounts");
		System.out.println("6 - Quit");
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
