package accounts;

public class Account {
	private int amount;
	private String name;
	private int id;
	
	public Account(int amount, String name)	{
		if(amount > 0)	{
			this.amount = amount;
		}
		else	{
			this.amount = 0;
		}
		this.name = name;
	}
	
	public Account(int amount, String name, int id)	{
		if(amount > 0)	{
			this.amount = amount;
		}
		else	{
			this.amount = 0;
		}
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "name=" + name + ", amount=" + amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object a) {
		if(((Account) a).getId() == this.getId()) {
			return true;
		}
		return false;
	}

}
