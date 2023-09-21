package vector;

import java.util.Vector;

public class Vector2 {
	public static void main(String[] args) {

		// vector with size
		int size = 20;
		Vector<Integer> vct2 = new Vector<>(size);

		for (int i = 1; i <= size; i++) {
			vct2.add(i);
		}
		System.out.println(vct2);
		//index number
		vct2.remove(3);
		System.out.println(vct2);

		// updating elements
		vct2.set(5, 50);
		System.out.println(vct2);

		vct2.insertElementAt(190,19);
		System.out.println(vct2);

		vct2.addElement(1000);

		System.out.println(vct2);
	}

}
