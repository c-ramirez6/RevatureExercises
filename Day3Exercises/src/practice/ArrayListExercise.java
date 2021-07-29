package practice;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExercise {

	public static void main(String[] args) {
		System.out.println("1:");
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Orange");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Purple");
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("2:");
		for(String color : colors) {
			System.out.println(color);
		}
		
		System.out.println("---------------------");
		System.out.println("3:");

		colors.add(0, "Red");
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("4:");
		
		getColor(colors, 3);
		
		System.out.println("---------------------");
		System.out.println("5:");
		colors.set(2, "Yellow");
		//updateColor(colors, 2, "Yellow");
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("6:");
		colors.remove(2);
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("7:");
		
		String target = "Purple";
		System.out.println(colors.contains(target));
		
		System.out.println("---------------------");
		System.out.println("8:");
		Collections.sort(colors);
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("9:");
		ArrayList<String> animals = new ArrayList<>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		colors.addAll(animals);
		ArrayList<String> colorsAndAnimals = colors;
		System.out.println(colorsAndAnimals);
		
		System.out.println("---------------------");
		System.out.println("10:");
		
		Collections.shuffle(colors);
		System.out.println(colors);
		
		System.out.println("---------------------");
		System.out.println("11:");
		
		ArrayList<String> reverseColors = new ArrayList<>();
		for(int i = colors.size()-1; i >= 0; i--)	{
			reverseColors.add(colors.get(i));
		}
		System.out.println(reverseColors);
		
		System.out.println("---------------------");
		System.out.println("12:");
		System.out.println("Before Extract: ");
		System.out.println(colors);
		int start = 1;
		int end = 3;
		ArrayList<String> extractTo = new ArrayList<>();
		for(int i = start; i <= end; i++) {
			extractTo.add(colors.get(start));
			colors.remove(start);
		}
		System.out.println("After extract: ");
		System.out.println(colors);
		System.out.println(extractTo);
		
		
		System.out.println("---------------------");
		System.out.println("13:");
		
		Collections.swap(colors, 0, 1);
		System.out.println(colors);
	}
	
	public static void getColor(ArrayList<String> colors, int index) {
		if(index < colors.size()) {
			System.out.println(colors.get(index));
		}
		else	{
			System.out.println("Index: " + index + " is out of bounds for arrayList of size: " + colors.size());
		}
	}
	
	public static ArrayList<String> updateColor(ArrayList<String> colors, int index, String color){
		if(index < colors.size())	{
			colors.remove(index);
			colors.add(index, color);
			return colors;
		}
		else	{
			System.out.println("Index: " + index + " is out of bounds for arrayList of size: " + colors.size());
		}
		return colors;
	}
	
}
