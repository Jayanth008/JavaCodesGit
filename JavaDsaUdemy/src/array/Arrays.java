package array;

public class Arrays {

	public static void main(String[] args) {

		int[] intArray = new int[7];
		// we can't increse or decrese array size
		intArray[0] = 20;
		intArray[1] = 35;
		intArray[2] = -15;
		intArray[3] = 7;
		intArray[4] = 55;
		intArray[5] = 1;
		intArray[6] = -22;

		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
//		 Big O Notation is a tool used to describe the time complexity of algorithms.
//		 It calculates the time taken to run an algorithm as the input grows. In other
//		 words, it calculates the worst-case time complexity of an algorithm
		
//			Runtime Complexity for Linear Search – O(n)
//			Runtime Complexity for Binary Search – O(log n)
//			Runtime Complexity for Bubble Sort, Selection Sort, Insertion Sort, Bucket Sort - O(n^c).
//			Runtime Complexity for Exponential algorithms like Tower of Hanoi - O(c^n).
//			Runtime Complexity for Heap Sort, Merge Sort - O(n log n).}

		
//		Arrays..........................>
//		continus block in memoery
//		every element accupy same amount of space in memory 
		
		
	}
}
