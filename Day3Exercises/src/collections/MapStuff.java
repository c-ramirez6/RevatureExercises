package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapStuff {

	public static void main(String[] args) {
		/*
		 * Implements map, does not maintain any order
		 * not synchronized and can have one null key and null values
		 */
		Map map = new HashMap();//Another way of constructing, but not great
		HashMap<Integer, String> hashMap = new HashMap<>();
		/*
		 * inherits from HashMap, but maintains insertion order
		 * 
		 */
		LinkedHashMap<Integer, String> lhMap = new LinkedHashMap<>();
		/*
		 * 
		 */
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		
		
		
		hashMap.put(1, "Chris");
		hashMap.put(2, "Evan");
		hashMap.put(3, "Kyle");
		
	}

}
