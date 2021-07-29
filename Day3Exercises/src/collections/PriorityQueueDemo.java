package collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		/*
		 * Impliments queue
		 * does not order in first in first out.
		 */
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.add("Matt");
		queue.add("Chris");
		queue.add("Evan");
		queue.add("Melody");
		queue.add("Max");
		
		for(String name : queue) {
			System.out.println(name);
		}
		String first = queue.poll();
		System.out.println("------------");
		System.out.println(first);//Chris
		/*
		 * peek and element work the exact same way except that peek can return null
		 * and element will throw an exception of the queue is empty
		 */
		queue.peek();
		queue.element();
		
		/*
		 * Same relationship as peek and element, but for removal
		 */
		queue.poll();
		queue.remove();
	}

}
