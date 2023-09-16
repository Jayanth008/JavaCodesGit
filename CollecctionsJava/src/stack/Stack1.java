package stack;

import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= 10; i++) {
			s.push(i);
		}
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s);
		s.push(100);
		System.out.println(s);
		System.out.println(s.search(9));
		System.out.println(s.empty());
	}
//	push() for inserting elements
//	pop() for removing and returning the top element
//	peek() for accessing the top element without removal
//	search() for finding the position of an element
//	empty() for checking if the stack is empty.
}
