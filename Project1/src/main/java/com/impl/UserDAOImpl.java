package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.connection.ConnectionFactory;
import com.users.Reimbursement;
import com.users.User;

public class UserDAOImpl implements UserDAO{
	
	private static Statement statement = null;
	Connection conn = null;
	
	public UserDAOImpl()	{
		try	{
			this.conn = ConnectionFactory.getConnection();
		}	catch(SQLException e)	{
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursements(int userId, List<Reimbursement> reims) throws SQLException {
		String sql = "select * from reimbursement where users_id =" + userId;
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		while(set.next())	{
			reims.add(new Reimbursement(set.getInt(1), set.getInt(2), set.getDouble(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7)));
		}
		return reims;
	}

	@Override
	public List<Reimbursement> getReimbursements(int userId, int type, List<Reimbursement> reims) throws SQLException {
		String sql = "select * from reimbursement where users_id =" + userId + " AND reimbursement_type=" + type;
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		while(set.next())	{
			reims.add(new Reimbursement(set.getInt(1), set.getInt(2), set.getDouble(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7)));
		}
		return reims;
	}

	@Override
	public void addReimbursement(Reimbursement reim) throws SQLException {
		String sql = "insert into reimbursement (users_id, reimbursement_amount, reimbursement_type, reimbursement_desc, reimbursement_creation, reimbursement_status) values"
				+ "(?, ?, ?, ?, ?, 1)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, reim.getUsers_id());
		pre.setDouble(2, reim.getAmount());
		pre.setString(3, reim.getType());
		pre.setString(4, reim.getDesc());
		pre.setString(5, reim.getDate());
		pre.executeUpdate();
	}

	@Override
	public User getUser(String username, String password) throws SQLException {
		String sql = "select * from users where users_username = '"+username+"' AND users_password = '"+password+"'";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet set = pre.executeQuery();
		while(set.next())	{
			return new User(set.getInt(1), set.getString(2), set.getString(3), set.getBoolean(4));
		}
		return null;
	}

}
