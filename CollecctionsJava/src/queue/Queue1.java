package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
	public static void main(String[] args) {

		// Create a Queue using LinkedList
		Queue<Integer> queue = new LinkedList<>();

		// Enqueue (add) elements to the queue
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);

		// Print the queue
		System.out.println("Queue: " + queue); // Output: Queue: [1, 2, 3]

		// Dequeue (remove and return) elements from the queue
		int removedElement = queue.poll();
		System.out.println("Dequeued: " + removedElement); // Output: Dequeued: 1

		// Peek at the front element without removing it
		int frontElement = queue.peek();
		System.out.println("Front element: " + frontElement); // Output: Front element: 2

		// Check if the queue is empty
		boolean isEmpty = queue.isEmpty();
		System.out.println("Is the queue empty? " + isEmpty); // Output: Is the queue empty? false

		// Get the size of the queue
		int queueSize = queue.size();
		System.out.println("Queue size: " + queueSize); // Output: Queue size: 2

		// Check if the queue contains a specific element
		boolean containsElement = queue.contains(2);
		System.out.println("Does the queue contain 2? " + containsElement); // Output: Does the queue contain 2? true

		// Remove the first occurrence of a specific element
		boolean removedSpecificElement = queue.remove(2);
		System.out.println("Removed the first occurrence of 2: " + removedSpecificElement);
		System.out.println("Queue after removal: " + queue); // Output: Removed the first occurrence of 2: true, Queue
																// after removal: [3]

		// Clear all elements from the queue
		queue.clear();
		System.out.println("Queue after clearing: " + queue); // Output: Queue after clearing: []
	}

}
