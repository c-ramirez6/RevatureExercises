package com.impl;

import java.sql.SQLException;
import java.util.List;

import com.users.Reimbursement;
import com.users.User;

public interface UserDAO {
	
	public List<Reimbursement> getReimbursements(int userId, List<Reimbursement> reims) throws SQLException;
	public List<Reimbursement> getReimbursements(int userId, int type, List<Reimbursement> reims) throws SQLException;
	
	public void addReimbursement(Reimbursement reim) throws SQLException;
	
	public User getUser(String username, String password) throws SQLException;
	
	

}
