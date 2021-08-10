package interfaces;

import java.sql.SQLException;
import java.util.List;

import accounts.Account;
import users.Customer;

public interface CustomerDAO {
	void addAccount(Account account, Customer customer) throws SQLException;
	
	void deposit(Customer customer, int amount, Account account) throws SQLException;
	
	void withdraw(Customer customer, int amount, Account account) throws SQLException;
	
	List<Account> viewBalance(Customer customer) throws SQLException;
	
	void transferMoney(Customer customer, Account toAccount, Account fromAccount, int amount) throws SQLException;
	
	void closeConnection() throws SQLException;
}
