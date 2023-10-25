package linkedlist;

import java.util.LinkedList;

// channging value of by index
public class LinkedList2 {
	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<>();

		ll.add("Geeks");
		ll.add("Geeks");
		ll.add(1, "Geeks");

		System.out.println("Initial LinkedList " + ll);

		ll.set(1, "For");

		System.out.println("Updated LinkedList " + ll);

		ll.remove(1);
		System.out.println("removed indes z LinkedList " + ll);
		System.out.println(ll.size());

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll);
	}
}
