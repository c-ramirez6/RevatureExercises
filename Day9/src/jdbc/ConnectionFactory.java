package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

	private static Connection conn = null;

	private ConnectionFactory() {

	}

	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("jdbc/dbConfig");
			String url = bundle.getString("url");
			String userName = bundle.getString("userName");
			String password = bundle.getString("password");
			conn = DriverManager.getConnection(url, userName, password);
		}
		return conn;
	}
}
