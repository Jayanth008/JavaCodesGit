package array;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 111, 3, 5, 7, 2, 1, 99, -3 };
		// time complxcity =O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int o : arr) {
			System.out.println(o);
		}
	}

}
