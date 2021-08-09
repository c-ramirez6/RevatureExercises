package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {
	
	private static Statement statement = null;
	Connection conn = null;
	
	public CustomerDAOImpl() {
		try	{
			this.conn = ConnectionFactory.getConnection();
		}	catch(SQLException e)	{
			e.printStackTrace();
		}
	}

	@Override
	public void addAccount(Account account, Customer customer) throws SQLException {
		String sql = "insert into temp_accounts (users_id, temp_accounts_name, temp_accounts_balance) values (?, ?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, customer.getId());
		pre.setString(2, account.getName());
		pre.setInt(3, account.getAmount());
		pre.executeUpdate();
		System.out.println("Account is now waiting for approval");
	}

	@Override
	public void deposit(Customer customer, int amount, Account account) throws SQLException {
		if(amount < 0)	{
			System.out.println("Invalid amount do deposit");
			return;
		}
		String sql = "update accounts set accounts_balance=" + (amount + account.getAmount()) + " where users_id=" + customer.getId() + " AND accounts_name=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account.getName());
		pre.executeUpdate();

	}

	@Override
	public void withdraw(Customer customer, int amount, Account account) throws SQLException {
		if(amount < 0 || amount > account.getAmount()) {
			System.out.println("Invalid amount to withdraw");
			return;
		}
		String sql = "update accounts set accounts_balance=" + (account.getAmount() - amount) + " where users_id=" + customer.getId() + " AND accounts_name=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account.getName());
		pre.executeUpdate();
	}

	@Override
	public List<Account> viewBalance(Customer customer) throws SQLException {
		String sql = "select * from accounts where users_id=" + customer.getId();
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		List<Account> accounts = new ArrayList<>();
		while (set.next()) {
			Account account = new Account(set.getInt(4), set.getString(3), set.getInt(1));
			accounts.add(account);
		}
		return accounts;
		

	}

	@Override
	public void transferMoney(Customer customer, Account toAccount, Account fromAccount, int amount) throws SQLException {
		String sql = "CALL transfer(?, ?, ?, ?, ?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, toAccount.getId());
		pre.setInt(2, fromAccount.getId());
		pre.setInt(3, amount);
		pre.setString(4, customer.getUsername());
		pre.setString(5, fromAccount.getName());
		pre.setString(6, toAccount.getName());
		pre.executeUpdate();

	}

}
