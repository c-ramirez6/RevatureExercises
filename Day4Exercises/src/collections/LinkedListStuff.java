package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListStuff {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("Paul");
		linkedList.add("Chris");
		linkedList.add("Kevin");
		linkedList.add("Anne");
		
		for(String name : linkedList)	{
			System.out.println(name);
		}
		System.out.println("-------------------");
		linkedList.add("Kyle");	//Adds to end of list
		linkedList.addFirst("Mark");//Adds to front of list
		linkedList.add(3, "Kelly");//Adds to specified index
		for(String name : linkedList) {
			System.out.println(name);
		}
		
		LinkedList<String> newList = new LinkedList<>();
		newList.add("Sarah");
		newList.add("Evan");
		newList.add("Mike");
		linkedList.addAll(newList);
		System.out.println("-----------------");
		for(String name : linkedList)	{
			System.out.println(name);
		}
		
		System.out.println("--------------------");
		Iterator<String> iter = linkedList.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("--------------------");
		for(int i = linkedList.size() - 1; i >= 0; i--) {
			System.out.println(linkedList.get(i));
		}
	}

}
