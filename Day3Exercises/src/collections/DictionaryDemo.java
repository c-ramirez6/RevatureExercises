package collections;

import java.util.Hashtable;

public class DictionaryDemo {

	public static void main(String[] args) {
		/*
		 * an array of a list
		 * IS synchronized
		 * does not allow null keys or values
		 * only unique values
		 */
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "Mark");
		table.put(2, "Evan");
		table.put(3, "Chris");
		table.put(4, "Kyle");
		
		for(Integer key : table.keySet()) {
			System.out.println(key + ": " + table.get(key));
		}
		
		/*
		 * HashMap vs Hashtable
		 * hashMap is not synchronized where a hashtable is
		 * hashMap allows 1 null key and multiple null values where hashtable does not allow any null values
		 * hashMap is faster (anything that is syncronized or thread safe will be slower)
		 * HashMap inherits from abstract map class where hashtable inherits from dictionary class
		 */

	}

}
