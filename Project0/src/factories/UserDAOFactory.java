package factories;

import database.UserDAOImpl;
import interfaces.UserDAO;

public class UserDAOFactory {
	private static UserDAO dao;
	
	private UserDAOFactory()	{
		
	}
	
	public static UserDAO getUserDao() {
		if(dao == null)	{
			return new UserDAOImpl();
		}
		return dao;
	}
}
