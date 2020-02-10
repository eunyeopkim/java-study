package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("둘리");
		list.add("마이콜");
		list.add("또치");

		// 순회 1
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		System.out.println();
		list.remove(1);
		list.remove(new String("둘리"));

		// 순회 2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		System.out.println();
		
		// 순회 3(for-each)
		for(String s : list) {
			System.out.println(s);
		}

	}
}
