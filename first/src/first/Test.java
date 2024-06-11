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
//		println("Hello Java");

		// 변수 선언 및 초기화
//		boolean tf = false;
//		println(tf);
//		tf = true; // 대입문 => 재사용, 재할당
//		println(tf);

		// 참조자료형 - 문자열
//		String str = "날씨가 참 좋네요";
//		println(str);

		// 연산
//		int a = 28 / 5;
//		int b = 28 % 5;
//		double d1 = 28.0 / 5;
//		double d2 = 28 / 5;
//
//		println(a);
//		println(b);
//		println(d1);
//		println(d2);

		// 형변환
//		byte b = 50;
//		int i = b;
//		b = (byte)i;
//		
//		println(b);
//		println(i);
//		
//		i = 128;
//		b = (byte)i;
//		
//		println(b);
//		println(i);

		// 원의 면적
//		int r = 5;
//		double pi = 3.141592;
//
//		println(r * r * pi);

		// 삼각형의 면적 구하기
		// 가로 : 7, 세로 : 5인 삼각형의 면적을 구하여 출력하세요.
//		int width = 7;
//		int height = 5;
//		float area = width * height / 2.0f;
//
//		println("The area of the triangle is " + area);

		// 전위연산자와 후위연산자 1
//		int a = 3;
//
//		++a;
//		println("1 : " + a);
//		a--;
//		println("2 : " + a);
//		println(++a);
//		println(a++);
//		println(a);

		// 전위연산자와 후위연산자 2
//		int a = 10, b = 10, c = a;
//
//		println("a : " + a + ", c : " + c);
//
//		c = ++a + b;
//		println("a : " + a + ", c : " + c);
//
//		c = a++ + b;
//		println("a : " + a + ", c : " + c);

		// 혼합대입연산자
//		int a = 10, b = a;
//		println(b);
//
//		b += a;
//		println(b);
//
//		b -= a;
//		println(b);
//
//		b *= a;
//		println(b);
//
//		b /= a;
//		println(b);
//
//		b %= a;
//		println(b);

		// 단축연산(논리연산인 경우 무시되는 부분이 발생)
		// 또한 연산자의 우선순위 중 전위연산자가 무시되는 경우가 발생된다.
		int value1 = 5;

		// 논리연산 논리곱(=AND =&&) : 두번째 항의 연산 무시
		println("논리연산 논리곱 &&");
		println(false && ++value1 > 6);
		println(value1);
		println(true && ++value1 > 6);
		println(value1);
		println("===================\n");

		// 논리연산 논리합(=OR =||) : 두번째 항의 연산 무시
		println("논리연산 논리합 ||");
		int value2 = 5;
		println(true || ++value2 > 6);
		println(value2);
		println(false || ++value2 > 6);
		println(value2);
		println("===================\n");
	}
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//