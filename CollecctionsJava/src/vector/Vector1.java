package vector;

import java.util.Vector;

public class Vector1 {

	public static void main(String[] args) {

		Vector<String> vector = new Vector<>();

		// Adding elements to the Vector
		vector.add("Apple");
		vector.add("Banana");
		vector.add("Cherry");

		// Accessing elements by index
		String firstElement = vector.get(0);
		System.out.println("First element: " + firstElement);

		// Iterating through the Vector
		System.out.println("Elements in the Vector:");
		for (String fruit : vector) {
			System.out.println(fruit);
		}

		// Checking if an element exists in the Vector
		if (vector.contains("Banana")) {
			System.out.println("Banana is in the Vector.");
		} else {
			System.out.println("Banana is not in the Vector.");
		}

		// Removing an element from the Vector
		vector.remove("Cherry");

		// Getting the size of the Vector
		int size = vector.size();
		System.out.println("Size of the Vector: " + size);
	}

}
