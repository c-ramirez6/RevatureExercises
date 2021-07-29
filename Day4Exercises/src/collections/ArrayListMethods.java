package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMethods {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<>();
		aList.add("Chris");
		aList.add("Paul");
		aList.add("Kyle");
		System.out.println(aList);
		for(String name : aList) {
			System.out.println(name);
		}
		Collections.sort(aList);
		aList.remove(2);
		for(String name : aList) {
			System.out.println(name);
		}
	}

}
