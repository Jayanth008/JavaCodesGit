package arraylist;

import java.util.ArrayList;

public class ArrayListIteration {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("shiva");
		names.add("ravi");
		names.add("jai");
		names.add("nani");

		synchronized (names) {

			// typical for loop
			System.err.println("typical for loop");
			for (String name : names) {
				System.out.println(name);
			}
		}
		synchronized (names) {

			// for each lopp
			System.err.println("for each lopp");
			for (String o : names) {
				System.out.println(o);
			}
		}

	}

}
