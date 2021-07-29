package practice;

import java.util.HashMap;

public class HashMapPractice {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		System.out.println("1:");
		map.put(1, "Chris");
		map.put(2, "Alex");
		map.put(3, "Evan");
		map.put(4, "Allie");
		System.out.println(map);
		
		System.out.println("---------------------");
		System.out.println("2:");
		System.out.println(map.size());
		
		System.out.println("---------------------");
		System.out.println("3:");
		HashMap<Integer, String> newMap = new HashMap<>();
		for(Integer i : map.keySet()) {
			newMap.put(i, map.get(i));
		}
		System.out.println(newMap);
		//newMap.putAll(map);	This also works
	}

}
