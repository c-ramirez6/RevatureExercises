package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeStuff {

	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		//insert element into the deque(At the tail) and return true when success
		//Preferable to offer when the deque has a capacity limit
		deque.add("Matt");
		//insert element into the deque the same as add, but this tends to be preferable because 
		//add can fail to add and throw exception
		deque.offer("Chris");
	}

}
