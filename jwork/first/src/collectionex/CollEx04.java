package collectionex;

import java.util.*;

public class CollEx04 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();

		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));

		Student uchi = new Student();
		uchi.setName("신원미상");
		uchi.setBan(-1);
		uchi.setNo(-1);
		list.add(uchi);
		
		uchi.setName("전우치");
		uchi.setBan(2);
		uchi.setNo(2); // uchi 변경 시 이전에 list에 uchi로 들어갔던 데이터까지 변경됨
//		list.add(uchi); // 동일한 자료가 2번 들어가게 됨

		Iterator<Student> it = list.iterator();

		while (it.hasNext()) {
//			Student s = it.next();
//			System.out.println(s.name + " " + s.ban + "반 " + s.no + "번");
			System.out.println(it.next().toString());
		}
	}
}

class Student {
	String name = "";
	int ban;
	int no;

	Student() {

	}

	Student(String str, int ban, int no) {
		this.name = str;
		this.ban = ban;
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return name + " " + ban + "반 " + no + "번";
	}
}