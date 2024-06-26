package collectionex;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

public class CollEx01 {
	public static void main(String[] args) {
		// 리스트 생성
		ArrayList<String> arrList = new ArrayList<String>();

		// 리스트에 요소의 저장
		arrList.add("넷");
		arrList.add("둘");
		arrList.add("셋");
		arrList.add("하나");
		System.out.println("arrList: " + arrList);
		System.out.println("arrList 방길이 : " + arrList.size());

		// 리스트 요소의 출력
		for (String s : arrList)
			System.out.println(s);

		arrList.remove(1);
		System.out.println("arrList: " + arrList);
		System.out.println("arrList 방길이 : " + arrList.size());

		arrList.clear();
		System.out.println("arrList: " + arrList);
		System.out.println("arrList 방길이 : " + arrList.size());

		List<String> lst = new ArrayList<String>();
		lst.add("alpha");
		lst.add("beta");
		lst.add("charlie");
		System.out.println("lst객체: " + lst);
		System.out.println("\n==============================\n");

//		Iterator iter = lst.iterator(); // 1.5 이하 표현, Object로 받아옴. 
		Iterator<String> iter = lst.iterator();

		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}

		System.out.println("\n==============================\n");
		for (String str : lst)
			System.out.println(str);

		System.out.println("\n==============================\n");
		for (int i = 0; i < lst.size(); i++)
			System.out.println("인덱스 [" + i + "]: " + lst.get(i));
	}
}
