	package chapter03;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		int[] a1 = {10, 20, 30, 40, 50};
		
		// static 메소드가 아니라면?
		// ArrayUtils au = new ArrayUtils();
		// double [] d1 = au.intTodouble(a1);
		
		// => 로 변경 가능
		double [] d1 = ArrayUtils.intTodouble(a1);
		
		for(int i=0; i<d1.length; i++) {
			System.out.print(d1[i]+" ");
		}
		System.out.println();
		int [] i1 = ArrayUtils.doubleToInt(d1);
		
		for(int i=0; i<i1.length; i++) {
			System.out.print(i1[i]+" ");
		}
		System.out.println();
		
		int[] result = ArrayUtils.concat(a1, i1);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
		
		
	}

}
