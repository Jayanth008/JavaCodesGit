package arraylist;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayList1 {

	public static void main(String[] args) {
//		int[] i = new int[4];
//		i[0] = 60;
//		i[2] = 50;
//		for (int j : i) {
//			System.out.println(j);
//		}

		// default class
		// dynamic array
		// default generics
		Collection<Object> obj = new ArrayList<>();
		System.out.println(obj.size());
		obj.add("shiva");
		obj.add("jai");
		obj.add("22");
		System.out.println(obj.size());
		obj.add(11);
		obj.add("12.6");
		obj.add(99.0);
		obj.add(true);
		System.out.println(obj.size());
		System.err.println(obj);

	}

}
