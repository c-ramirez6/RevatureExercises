package interfaces;

import java.sql.SQLException;
import java.util.List;

import accounts.Account;

public interface AdminDAO {
	void approveAccounts(Account account) throws SQLException;
	
	void declineAccounts(Account account) throws SQLException;
	
	void listTransactions() throws SQLException;
	
	List<Account> getAllPendingAccounts() throws SQLException;
	
	void closeConnection() throws SQLException;
}
