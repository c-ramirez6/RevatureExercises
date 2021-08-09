package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO{
	
	private static Statement statement = null;
	Connection conn = null;
	
	public UserDAOImpl() {
		try	{
			this.conn = ConnectionFactory.getConnection();
		}	catch(SQLException e)	{
			e.printStackTrace();
		}
	}

	@Override
	public User registerAccount(User user) throws SQLException {
		String sql = "insert into users (users_name, users_username, users_password, users_admin) values (?, ?, ?, '2')";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, user.getName());
		pre.setString(2, user.getUsername());
		pre.setString(3, user.getPassword());
		int count = pre.executeUpdate();
		if (count > 0) {
			System.out.println("User saved");
		} else {
			System.out.println("User not saved error occured");
		}
		sql = "select * from users where users_username = ?";
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getUsername());
		ResultSet set = pre.executeQuery();
		while(set.next()) {
			user.setId(set.getInt(1));
			user.setName(set.getString(2));
			user.setUsername(set.getString(3));
			user.setPassword(set.getString(4));
		}
		return user;
		
	}

	@Override
	public int getUser(User user) throws SQLException {
		String sql = "select * from users where users_username = ? AND users_password= ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, user.getUsername());
		pre.setString(2, user.getPassword());
		ResultSet set = pre.executeQuery();
		while(set.next()) {
			user.setId(set.getInt(1));
			user.setName(set.getString(2));
			user.setUsername(set.getString(3));
			user.setPassword(set.getString(4));
			if(set.getString(5).equals("true"))	{
				return 1;
			}
			else if(set.getString(5).equals("false"))	{
				return 2;
			}
		}
		return 0;
	}

}
