package factories;

import database.CustomerDAOImpl;
import interfaces.CustomerDAO;

public class CustomerDAOFactory {
	private static CustomerDAO dao;
	
	private CustomerDAOFactory()	{
		
	}
	
	public static CustomerDAO getCustomerDao() {
		if(dao == null)	{
			return new CustomerDAOImpl();
		}
		return dao;
	}
}
