package testing;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accounts.Account;
import database.CustomerDAOImpl;
import users.Customer;

public class Testing {
	
	@Test
	public void listAccountTest(){
		CustomerDAOImpl cust = new CustomerDAOImpl();
		Customer customer = new Customer(1, "Chris Ramirez", "crami", "password");
		List<Account> actualAccounts = new ArrayList<>();
		try {
			actualAccounts = cust.viewBalance(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Account> expectedAccounts = new ArrayList<>();
		expectedAccounts.add(new Account(1100, "Chris Checking Account", 1));
		expectedAccounts.add(new Account(550, "Chris Savings", 2));
		expectedAccounts.add(new Account(5000, "New Account", 3));
		
		assertEquals(expectedAccounts, actualAccounts);
		
	}

}
