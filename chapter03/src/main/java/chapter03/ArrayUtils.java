	package chapter03;

public class ArrayUtils {
	public static double[] intTodouble(int[] src) {
		double[] result = null;
		if (src == null) {
			return null;
		}
		int size = src.length;
		result = new double[size];
		for (int i = 0; i < size; i++) {
			result[i] = src[i];
		}

		return result;
	}

	public static int[] doubleToInt(double[] src) {
		int[] result = null;
		if (src == null) {
			return null;
		}
		int size = src.length;
		result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = (int) (src[i]);
		}

		return result;
	}

	public static int[] concat(int[] s1, int[] s2) {
		int[] result = null;
		int size = s1.length + s2.length;
		result = new int[size];
		for (int i = 0; i < s1.length; i++) {
			result[i] = s1[i]+s2[i];
		}
		for (int j = 0; j < result.length; j++) {
				result[j+s1.length-1] = s2[j];
		}

		return result;

	}
}
