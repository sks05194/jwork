package inheritance;

public class Super03 {
	public static void main(String[] args) {
		AA3 super1 = new AA3();
		System.out.println("10의 2제곱 : " + super1.d1);
		System.out.println("10의 3제곱 : " + super1.d2);
		System.out.println("10의 4제곱 : " + super1.d3);
	}
}

class AA1 {
	double d1;
	AA1() {
		System.out.println("AA1의 생성자");
		d1 = 10 * 10;
	}
	AA1(double d1){
		System.out.println("AA1의 생성자");
		d1 = 10 * 10;
	}
}

class AA2 extends AA1 {
	double d2;
	AA2() {
		super();
//		super(100); // 부모클래스의 기본생성자 소멸 시 사용해야 함.
		System.out.println("AA2의 생성자");
		d2 = d1 * 10;
	}
}

class AA3 extends AA2 {
	double d3;
	AA3() {
		super(); // 부모의 기본생성자 호출문이 자동으로 숨겨져있다.
		System.out.println("AA3의 생성자");
		d3 = d2 * 10;
	}
}