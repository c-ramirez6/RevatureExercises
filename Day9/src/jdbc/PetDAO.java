package jdbc;

import java.sql.SQLException;
import java.util.List;

public interface PetDAO {
	void addPet(Pet pet) throws SQLException;
	void updatePet(int id, String name, int weight) throws SQLException;
	void deletePet(int id) throws SQLException;
	List<Pet> getPets() throws SQLException;
	Pet getPet(int id) throws SQLException;
	void close() throws SQLException;
}
