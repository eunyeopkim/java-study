package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack<String> stack = new MyStack(3);	// 제네릭은 <String>으로 캐스팅해야 String 가능
													// Object로 구현시 컴파일때 오류확인 x, 제네릭으로 해야 확인 가능
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}
