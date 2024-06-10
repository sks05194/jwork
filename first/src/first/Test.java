package first;

public class Test {
	// 출력 코드 길게 쓰기 귀찮아서 만든 메서드1
	public static void println(Object obj) {
		System.out.println(obj);
	}

	// 출력 코드 길게 쓰기 귀찮아서 만든 메서드2
	public static void print(Object obj) {
		System.out.print(obj);
	}

	public static void main(String[] args) {
		// 출력 연습
		println("Hello Java");

		// 변수 선언 및 초기화
		boolean tf = false;
		println(tf);
		tf = true; // 대입문 => 재사용, 재할당
		println(tf);

		// 참조자료형 - 문자열
		String str = "날씨가 참 좋네요";
		println(str);

		// 연산
		int a = 28 / 5;
		int b = 28 % 5;
		double d1 = 28.0 / 5;
		double d2 = 28 / 5;
		
		println(a);
		println(b);
		println(d1);
		println(d2);
	}
}