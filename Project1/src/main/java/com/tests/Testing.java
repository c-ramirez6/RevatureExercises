package com.tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.impl.UserDAOImpl;
import com.users.Reimbursement;
import com.users.User;

public class Testing {
	
	@Test
	public void loginTest()	{
		UserDAOImpl dao = new UserDAOImpl();
		User expectedUser = new User(1, "crami", "password", false);
		User user = null;
		try {
			user = dao.getUser("crami", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(expectedUser.toString(), user.toString());
	}
	
	@Test
	public void getAllReimbursementsTest()	{
		UserDAOImpl dao = new UserDAOImpl();
		List<Reimbursement> expectedReims = new ArrayList<>();
		List<Reimbursement> reims = new ArrayList<>();
		try {
			reims = dao.getAllReimbursements(1, reims);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		expectedReims.add(new Reimbursement(9, 1, 100.50, "Other", "Test1", "2021-07-15", "Pending"));
		expectedReims.add(new Reimbursement(10, 1, 900.00, "Lodging", "test 2", "2021-09-01", "Pending"));
		for(int i = 0; i < reims.size(); i++) {
			assertEquals(expectedReims.get(i).toString(), reims.get(i).toString());
		}
	}

}
