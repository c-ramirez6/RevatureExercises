package database;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO {
	void approveAccounts(Account account) throws SQLException;
	
	void listTransactions() throws SQLException;
	
	List<Account> getAllPendingAccounts() throws SQLException;
}
