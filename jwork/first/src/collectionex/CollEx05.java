package collectionex;

import java.util.*;

public class CollEx05 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");

		Set<String> keys = map.keySet();
		
		// 출력문 Iterator 사용하지 않고 출력하기
//		for(String key : keys)
//			System.out.printf("key : %s\t value : %s\n", key, map.get(key));
		
		Iterator<String> iter = keys.iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.printf("key : %s\t value : %s\n", key, map.get(key));
		}
		
		Collection<String> value = map.values();
		
		// 출력문 Iterator 사용하지 않고 출력하기
//		for(String s : value)
//			System.out.printf("value : %s\n",s);
		
		iter = value.iterator();
		while (iter.hasNext())
			System.out.printf("value : %s\n", iter.next());
	}
}