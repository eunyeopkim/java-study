package chapter04;
/*
 * Singleton + Factory Method Test
 * @author eykk
 * 
 */

public class MyClass {
	private static MyClass instance = null;
	
	
	private MyClass() {
		
	}
	
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		
		return instance;
	}
}
