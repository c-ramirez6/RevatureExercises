package interfaces;

import java.sql.SQLException;

import users.User;

public interface UserDAO {
	User registerAccount(User user) throws SQLException;
	
	int getUser(User user) throws SQLException;
	
	void closeConnection() throws SQLException;
}
