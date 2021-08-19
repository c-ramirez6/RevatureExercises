package com.employee;


public class EmployeeDAOFactory {
	private static EmployeeDAO dao;
	
	private EmployeeDAOFactory()	{
		
	}
	
	public static EmployeeDAO getEmployeeDao() {
		if(dao == null)	{
			return new EmployeeDAOImpl();
		}
		return dao;
	}
}
