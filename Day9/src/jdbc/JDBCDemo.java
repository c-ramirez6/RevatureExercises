package jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException {

		Scanner in = new Scanner(System.in);
		PetDAO petDao = PetDAOFactory.getPetDao();

		String option = "";
		while (!option.equals("6")) {
			System.out.println("*****************");
			System.out.println("Select an option: ");
			System.out.println("1- Add a pet");
			System.out.println("2- Delete a pet");
			System.out.println("3- Update pet record");
			System.out.println("4- Show list of all pets");
			System.out.println("5- Show single pet by id");
			System.out.println("6- Exit");

			option = in.nextLine();

			switch (option) {
			case "1": {
				Pet pet = new Pet();
				System.out.println("Enter pet's name: ");
				pet.setName(in.nextLine());
				System.out.println("Enter " + pet.getName() + "'s weight: ");
				pet.setWeight(in.nextInt());
				in.nextLine();
				petDao.addPet(pet);
				System.out.println("");
				break;
			}

			case "2": {
				System.out.println("Enter the pet's Id: ");
				petDao.deletePet(in.nextInt());
				in.nextLine();
				System.out.println("");
				break;
			}
			case "3": {
				System.out.println("Enter id of pet to update: ");
				int id = in.nextInt();
				in.nextLine();
				System.out.println("Enter new name: ");
				String name = in.nextLine();
				System.out.println("Enter new weight: ");
				int weight = in.nextInt();
				in.nextLine();
				petDao.updatePet(id, name, weight);
				System.out.println("");
				break;
			}

			case "4": {
				List<Pet> pets = petDao.getPets();
				for (Pet pet : pets) {
					System.out.println(pet);
				}
				System.out.println("");
				break;
			}
			case "5": {
				System.out.println("Enter pet id: ");
				int id = in.nextInt();
				in.nextLine();
				System.out.println(petDao.getPet(id));
				System.out.println("");
				break;
			}
			case "6": {
				in.close();
				petDao.close();
				break;
			}
			}
		}
	}
}
