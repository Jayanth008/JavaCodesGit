package practice1;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Class1 {
	public static void main(String[] args) {
		List<String> ar=List.of("J","o","k","oo","uu","yyy","o");
		System.out.println(ar);
		Set<String> se=new TreeSet<>();
		se.addAll(ar);
		System.out.println(se);
	}

}
