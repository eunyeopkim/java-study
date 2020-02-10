package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i <= 99; i++) {
			int num = i / 10;
			int count = 0;
			if (num == 3 || num == 6 || num == 9) {
				count++;
			}
			num = i % 10;
			if (num == 3 || num == 6 || num == 9) {
				count++;
			}
			if (count == 1) {
				System.out.println(i + " 짝");
			}
			if (count == 2) {
				System.out.println(i + " 짝짝");
			}

		}
	}
}
