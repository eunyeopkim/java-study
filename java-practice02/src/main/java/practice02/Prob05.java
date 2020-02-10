package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		int high = 100, low = 1;
		int i = 0;
		loops: while (true) {
			i++;
			System.out.println(low + "-" + high);
			System.out.print(i + ">>");
			int n = scanner.nextInt();
			if (n == k) {
				System.out.println("맞았습니다.");
				System.out.print("다시하시겠습니까(y/n)>>");
				String answer = scanner.next();
				if (answer.equals("y")) {
					k = r.nextInt(100) + 1;
					System.out.println(k);
					System.out.println("수를 결정하였습니다. 맞추어 보세요");
					high = 100;
					low = 1;
					i = 0;
				} else {
					break loops;
				}
			} else if (n != k && n < k) {
				low = n;
				System.out.println("더 높게");
			} else if (n != k && n > k) {
				high = n;
				System.out.println("더 낮게");
			}

		}
		scanner.close();

	}
}
