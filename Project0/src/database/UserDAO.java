package database;

import java.sql.SQLException;

public interface UserDAO {
	User registerAccount(User user) throws SQLException;
	
	User getUser(User user) throws SQLException;
}
