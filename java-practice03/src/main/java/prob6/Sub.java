package prob6;

public class Sub {
	public int a;
	public int b;
	public int result;

	public void setValue(int lValue, int rValue) {
		a= lValue;
		b= rValue;

	}
	public int calculate() {
		
		result = a - b;
		return result;
	}
}
