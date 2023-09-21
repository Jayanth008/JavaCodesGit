package arraylist;

import java.util.ArrayList;

public class GenericsArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> obj = new ArrayList<>();
		obj.add(10);
		obj.add(20);
		obj.add(30);
		obj.add(40);
		obj.add(50);
		obj.add(60);

		ArrayList<Double> doubleObj = new ArrayList<>();
		doubleObj.add(10.1);
		doubleObj.add(10.2);
		doubleObj.add(10.3);
		doubleObj.add(10.4);
		doubleObj.add(10.5);

	}

}
