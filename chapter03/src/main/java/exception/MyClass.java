package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1");
		System.out.println("some code2");
		
		if(5 - 5 == 0) {
			throw new IOException();
		}
		
		if(10 - 2 == 8) {
			//throw new IOException();
			throw new MyException();
		}
		
		System.out.println("some code3");
		System.out.println("some code4");
	}
}
