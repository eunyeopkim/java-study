package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		String s1 = new String("또치");
		String s2 = new String("또치");
		String s3 = "또치";

		System.out.println(s1 == s2);

		set.add("둘리");
		set.add("마이콜");
		set.add(s1);

		System.out.println(set.contains(s2));
		System.out.println(set.size());

		System.out.println();
		// 순회
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
	}

}
