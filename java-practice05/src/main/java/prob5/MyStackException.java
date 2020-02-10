package prob5;

public class MyStackException extends Exception {
//	public MyStackException() {
//		super("stack is empty");
//	}
	
	public MyStackException() {
		super("MyStack is Empty");
	}
	
	public MyStackException(String msg) {
		super(msg);
	}
	
}
