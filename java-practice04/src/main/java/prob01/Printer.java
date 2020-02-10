package prob01;

public class Printer {
//	public int i;
//
//	public void println(int i, int j, int k, int l, int m, String string, StringBuffer stringBuffer) {
//		System.out.println(i+" "+j+" "+k+" "+l+" "+m+" "+string+" "+stringBuffer);
//	}
//	public void println(boolean b) {
//		System.out.println(b);
//		
//	}
//	public void println(int i) {
//		System.out.println(i);
//		
//	}
//	public void println(double d) {
//		System.out.println(d);
//		
//	}
//	public void println(String s) {
//		System.out.println(s);
//		
//	}
//	public <T> void println(T t) {
//		System.out.println(t);
//	}
//	
//	// 가변변수
//	public int sum(int ... nums) {
//		int sum = 0 ;
//		for(int i : nums) {
//			sum += i;
//		}
//		
//		return sum;
//	}
//	
	public <T> void println(T...ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}

}
