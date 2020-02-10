package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] result = str.toCharArray();
		for (int i = str.length() - 1; i >= 0; i--) {
			result[str.length() - 1 - i] = str.charAt(i);
		}
		return result;

	}

	public static void printCharArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
