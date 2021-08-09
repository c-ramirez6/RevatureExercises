package database;

public class AdminDAOFactory {
	private static AdminDAO dao;
	
	private AdminDAOFactory()	{
		
	}
	
	public static AdminDAO getAdminDao() {
		if(dao == null)	{
			return new AdminDAOImpl();
		}
		return dao;
		
	}

}
