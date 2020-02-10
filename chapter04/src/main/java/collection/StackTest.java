package collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();

		st.push("둘리");
		st.push("마이콜");
		st.push("또치");

		while (!st.isEmpty()) {
			String str = st.pop();
			System.out.println(str);
		}
		System.out.println();
		// 비어있는 경우 , StackException 발생
		// st.pop();
		st.push("둘리");
		st.push("마이콜");
		st.push("또치");
		
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.pop());
		
	}
}
