package threads;

class Bank	{
	int balance;
	
	public synchronized void withdraw(int amount) {
		System.out.println("Withdrawing amount....");
		if(balance < amount) {
			System.out.println("Not enough funds to withdraw amount... Wait for deposit");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		balance -= amount;
		System.out.println("Finished withdrawing");
	}
	
	synchronized void deposit(int amount) {
		System.out.println("Depositing amount....");
		balance += amount;
		System.out.println("Finished depositing");
		notify();
	}
}

class DepositThread extends Thread	{
	Bank bank;
	
	public DepositThread(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		bank.deposit(20000);
	}
	
}

class WithdrawThread extends Thread	{
	Bank bank;
	
	public WithdrawThread(Bank bank)	{
		this.bank = bank;
	}
	
	@Override
	public void run()	{
		bank.withdraw(15000);
	}
}

public class BankExample {

	public static void main(String[] args) {
		Bank bank = new Bank();
		WithdrawThread wThread = new WithdrawThread(bank);
		DepositThread dThread = new DepositThread(bank);
		
		wThread.start();
		dThread.start();

	}

}
