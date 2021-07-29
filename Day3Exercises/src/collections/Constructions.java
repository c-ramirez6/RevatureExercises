package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Constructions {

	public static void main(String[] args) {
		//Array list default constructor the <> is for generics allowing for a specific data type in the list
		ArrayList<String> aList = new ArrayList<>();
		aList.add("Chris");
		aList.add("Paul");
		aList.add("Kyle");
		System.out.println(aList);
		//HashMap constructor with an integer as the key and a string as the value
		HashMap<Integer, String> hMap = new HashMap<>();
		//Priority Queue constructor.  Just Queue is an interface so you can't construct it
		PriorityQueue<String> queue = new PriorityQueue<>();

	}

}
