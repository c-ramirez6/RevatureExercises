package com.impl;

public class UserDAOFactory {
	private static UserDAO dao;
	
	private UserDAOFactory()	{
		
	}
	
	public static UserDAO getUserDao()	{
		if(dao == null) {
			return new UserDAOImpl();
		}
		return dao;
	}

}
