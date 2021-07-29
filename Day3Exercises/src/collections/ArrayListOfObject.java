package collections;

import java.util.ArrayList;

class Pet	{
	private String name;
	private int age;
	private double weight;
	public Pet(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public String toString()	{
		return "Pet[name=" + this.name + ", age=" + this.age + ", weight=" + this.weight + "]";
		
	}
}

public class ArrayListOfObject {

	public static void main(String[] args) {
		Pet p1 = new Pet("Fido", 3, 35.5);
		Pet p2 = new Pet("Max", 10, 135.5);
		Pet p3 = new Pet("Rex", 1, 24.0);
		ArrayList<Pet> pets = new ArrayList<>();
		pets.add(p1);
		pets.add(p2);
		pets.add(p3);
		for(Pet pet : pets)	{
			System.out.println(pet);
		}

	}

}
