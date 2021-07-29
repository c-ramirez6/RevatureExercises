package practice;

import java.util.LinkedList;

public class LinkedListPractice {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Chris");
		list.add("Tom");
		list.add("Alex");
		
		System.out.println("---------------------");
		System.out.println("1:");
		list.addLast("Mike");
		System.out.println(list);

		System.out.println("---------------------");
		System.out.println("2:");
		for(String name : list)	{
			System.out.println(name);
		}
		
		System.out.println("---------------------");
		System.out.println("3:");
		
		int index = 1;
		for(int i = index; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------------------");
		System.out.println("4:");
		for(int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------------------");
		System.out.println("5:");
		int position = 3;
		list.add(position, "Beth");
		System.out.println(list);
	}

}
