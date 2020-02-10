package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		String ks1 = "one";
		map.put(ks1, 1); // auto boxing
		map.put("two", 2);
		map.put("three", 3);

		int i = map.get(ks1); // auto unboxing
		int j = map.get(new String("one"));
		System.out.println(i + " : " + j);

		map.put("three", 33333);
		System.out.println(map.get("three"));
		System.out.println();
		Set<String> s = map.keySet(); // keySet()으로 인한 Map의 key순회가능
		for (String key : s) {
			int value = map.get(key);
			System.out.println(value);
		}
	}
}
