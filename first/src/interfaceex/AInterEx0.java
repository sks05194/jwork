package interfaceex;

public class AInterEx0 {
	public static void main(String[] args) {
		A memo;
		memo = new C1();
		memo.display("안녕하세요");
		
		memo = new C2();
		memo.display("즐거운 자바 수업 시간입니다.");
		
		memo = new C3();
		memo.display("자바를 잡아봅시다.");

		memo.dfmd("\"안녕 자바\"");
		System.out.println(A.stmd(5) + C3.stmd(1));
//		System.out.println(A.stmd(5) + memo.stmd(1));
	}
}

class C1 implements A {
	@Override
	public void display(String s) {
		System.out.println("클래스 C1 객체 이용 : " + s);
	}

	@Override
	public void imd() {
		System.out.println("imd 메소드 재정의");
	}
}

class C2 implements A {
	@Override
	public void display(String s) {
		System.out.println("클래스 C2 객체 이용 : " + s);
	}

	@Override
	public void imd() {
		System.out.println("imd 메소드 재정의");
	}
}

class C3 implements A {
	@Override
	public void display(String s) {
		System.out.println("클래스 C3 객체 이용 : " + s);
	}

	@Override
	public void dfmd(String str) {
		int a = 5;
		System.out.println("C3 클래스 안의 dfmd 메소드의 str 변수 값 : " + str + "와 CONS의 값: " + CONS + "와 a의 값: " + a);
	}

	public void dfmd() {
		System.out.println("dfmd() 메소드 오버로딩");
	}

	static int stmd(int a) {
		return CONS + a;
	}

	@Override
	public void imd() {
		System.out.println("imd 메소드 재정의");
	}
}