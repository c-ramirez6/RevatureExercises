package jdbc;

public class PetDAOFactory {

	private static PetDAO dao;
	
	private PetDAOFactory()	{
		
	}
	
	public static PetDAO getPetDao()	{
		if(dao == null)	{
			dao = new PetDAOImpl();
		}
		return dao;
	}
	
}
