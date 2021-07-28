package exceptions;

class poorFundException extends Exception	{
	public poorFundException() {
		System.out.println("Not enough funds to withdraw");
	}
	
	public poorFundException(String message)	{
		System.out.println(message);
	}
}

class bankAccount	{
	private int balance = 0;
	private int accountNum;
	
	public bankAccount(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public void deposit(int amount)	{
		balance += amount;
		System.out.println("Amount: " + amount + " Deposited");
	}
	
	public void withdraw(int amount) throws poorFundException	{
		if(amount <= balance)	{
			balance -= amount;
			System.out.println("Amount withdrawn: " + amount);
		}
		else	{
			throw new poorFundException("You dont have enough money");
		}
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNum;
	}
}

public class ExceptionExample {

	public static void main(String[] args) {
		bankAccount ba = new bankAccount(123);
		System.out.println(ba.getBalance());
		 ba.deposit(5000);
		 try {
			ba.withdraw(2000);
		} catch (poorFundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ba.deposit(1000);
		 try {
			ba.withdraw(10000);
		} catch (poorFundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(ba.getBalance());
	}

}
