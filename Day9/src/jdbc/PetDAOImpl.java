package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO{
	
	private static Statement statement = null;
	Connection conn = null;
	
	public PetDAOImpl()	{
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPet(Pet pet) throws SQLException {
		String sql = "insert into pets (name, weight) values (?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, pet.getName());
		pre.setInt(2, pet.getWeight());
		int count = pre.executeUpdate();
		if(count > 0) {
			System.out.println("pet saved");
		}
		else	{
			System.out.println("pet not saved error occured");
		}
	}

	@Override
	public void updatePet(int id, String name, int weight) throws SQLException {
		String sql1 = "select * from pets where id = " + id;
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql1);
		Pet pet1 = null;
		while(set.next()) {
			pet1 = new Pet(set.getInt(1), set.getString(2), set.getInt(3));
		}
		String sql2 = "update pets set name=?, weight = ? where id = ?";
		PreparedStatement pre = conn.prepareStatement(sql2);
		pre.setString(1, name);
		pre.setInt(2, weight);
		pre.setInt(3, id);
		int count = pre.executeUpdate();
		if(count > 0)	{
			System.out.println("Updated record");
		}
		else	{
			System.out.println("Error when updating record");
		}
		
	}

	@Override
	public void deletePet(int id) throws SQLException {
		String sql = "delete from pets where id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, id);
		int count = pre.executeUpdate();
		if(count > 0)	{
			System.out.println("Deleted record");
		}
		else	{
			System.out.println("Error when deleting record");
		}
		
	}

	@Override
	public List<Pet> getPets() throws SQLException {
		String sql = "select * from pets";
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		List<Pet> pets = new ArrayList<>();
		while(set.next()) {
			Pet pet = new Pet(set.getInt(1), set.getString(2), set.getInt(3));
			pets.add(pet);
		}
		return pets;
	}

	@Override
	public Pet getPet(int id) throws SQLException {
		String sql = "select * from pets where id = " + id;
		statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		Pet pet = null;
		while(set.next()) {
			pet = new Pet(set.getInt(1), set.getString(2), set.getInt(3));
		}
		
		return pet;
	}

	@Override
	public void close() throws SQLException {
		conn.close();
		System.out.println("Connection closed");
	}

}
