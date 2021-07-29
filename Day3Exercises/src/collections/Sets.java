package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		/*
		 * Hashset stores using hashing.  
		 * Can not have duplicate values
		 * Can store null value
		 * not synchronized
		 * does not maintain insertion order
		 * Good for search operations
		 */
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Mark");
		hashSet.add("Chris");
		hashSet.add("Evan");
		for(String name : hashSet) {
			System.out.println(name);
		}
		System.out.println("----------------------");

		/*
		 * Pretty much the same as normal Hashset but maintains insertion order
		 * Allows null
		 * not synchronized
		 */
		LinkedHashSet<String> lhSet = new LinkedHashSet<>();
		lhSet.add("Mark");
		lhSet.add("Chris");
		lhSet.add("Evan");
		for(String name : lhSet) {
			System.out.println(name);
		}
		System.out.println("----------------------");
		/*
		 * Objects are stored in ascending order.  Access and retreval times are fast
		 * Does not allow null
		 * not synchronized
		 * Does not allow duplicate values
		 */
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(14);
		treeSet.add(60);
		treeSet.add(42);
		treeSet.add(100);
		treeSet.add(375);
		for(int num : treeSet) {
			System.out.println(num);
		}
		System.out.println("-----------");
		System.out.println(treeSet.ceiling(1));	//Will return the first number that is greater than or equal to the argument
		System.out.println(treeSet.floor(41));	//
		
	}

}
