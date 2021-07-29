package practice;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPractice {

	public static void main(String[] args) {
		TreeSet<String> colors = new TreeSet<>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		System.out.println(colors);
		System.out.println("2:");
		
		for(String color : colors) {
			System.out.println(color);
		}
		
		System.out.println("---------------------");
		System.out.println("3:");
		TreeSet<String> animals = new TreeSet<>();
		animals.add("Cat");
		animals.add("Lizard");
		animals.addAll(colors);
		System.out.println(animals);
		
		System.out.println("---------------------");
		System.out.println("4:");
		Iterator<String> iterate = animals.descendingIterator();
		while(iterate.hasNext())	{
			System.out.println(iterate.next());
		}
		
		System.out.println("---------------------");
		System.out.println("5:");
		System.out.println(animals);
		String first = animals.first();
		String last = animals.last();
		System.out.println("First=" + first + ",Last=" + last);
	}

}
