package practice;

import java.util.HashSet;

public class HashSetPractice {

	public static void main(String[] args) {
		HashSet<String> animals = new HashSet<>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Lizard");
		animals.add("Bird");
		animals.add("Horse");
		System.out.println(animals);
		System.out.println("1:");
		/*
		 * You cant append objects to the end of a hashset
		 */
		animals.add("Rabbit");
		System.out.println(animals);

		System.out.println("---------------------");
		System.out.println("2:");
		
		for(String animal : animals)	{
			System.out.println(animal);
		}
		
		System.out.println("---------------------");
		System.out.println("3:");
		
		System.out.println(animals.size());
		
		System.out.println("---------------------");
		System.out.println("4:");
		
		animals.clear();
		System.out.println(animals);
	}

}
