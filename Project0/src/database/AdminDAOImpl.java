package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import accounts.Account;
import factories.ConnectionFactory;
import interfaces.AdminDAO;

public class AdminDAOImpl implements AdminDAO{
	
	private Statement statement = null;
	Connection conn = null;
	
	public AdminDAOImpl() {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void approveAccounts(Account account) throws SQLException {
		String sql = "insert into accounts (users_id, accounts_name, accounts_balance) values (?, ?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, account.getId());
		pre.setString(2, account.getName());
		pre.setInt(3, account.getAmount());
		pre.executeUpdate();
		String deleteSql = "delete from temp_accounts where users_id= ? AND temp_accounts_name= ? AND temp_accounts_balance= ?";
		pre = conn.prepareStatement(deleteSql);
		pre.setInt(1, account.getId());
		pre.setString(2, account.getName());
		pre.setInt(3, account.getAmount());
		pre.executeUpdate();
		System.out.println("Account added");
	}

	@Override
	public void listTransactions() throws SQLException {
		String sql = "select * from transactions";
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		while(set.next()) {
			System.out.println("Transaction id: " + set.getInt(1) + " users_username: " + set.getString(2) + " from_account: " + set.getString(3) + 
					" to_account: " + set.getString(4) + " transaction_amount: " + set.getInt(5));
		}
		
	}
	
	@Override
	public List<Account> getAllPendingAccounts() throws SQLException	{
		String sql = "select * from temp_accounts";
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		int count = 0;
		List<Account> accounts = new ArrayList<>();
		while(set.next())	{
			System.out.println((count+1) + " - temp account id: " + set.getInt(1) + " user id: " + set.getInt(2) + " account name: " + set.getString(3) + " account balance: " + set.getInt(4));
			Account account = new Account(set.getInt(4), set.getString(3), set.getInt(2));
			accounts.add(account);
			count++;
		}
		return accounts;
	}

	@Override
	public void declineAccounts(Account account) throws SQLException {
		String sql = "delete from temp_accounts where users_id= ? AND temp_accounts_name= ? AND temp_accounts_balance= ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, account.getId());
		pre.setString(2, account.getName());
		pre.setInt(3, account.getAmount());
		pre.executeUpdate();
	}

	@Override
	public void closeConnection() throws SQLException {
		conn.close();
		System.out.println("Connection closed");
		
	}

}
