package first;

public class Point02 {
	// 멤버필드 = 멤버변수 = 전역변수 = 인스턴스 변수(속성)
	int x;
	int y;

	// 생성자와 메소드의 차이점: 리턴타입 기술하는 부분이 존재하는지(메소드) 존재하지 않는지(생성자)에 따라 구분
	// 기본 생성자(매개변수가 없는 생성자이므로)
	// 기본생성자가 숨어있는 경우는 클래스 안에 아무것도 기술되어 있는 생성자가 없는 경우 숨겨있다.
	// 만약 생성자가 단 1개라도 기술되어 있는 것이 있으면 기본생성자는 덮어쓰기되어 사라진다.
	public Point02() {
		System.out.println("매개 변수가 없는 디폴트 생성자");
	}

	// 기타생성자(매개변수가 존재하는 생성자)
	public Point02(int new_x, int new_y) {
		System.out.println("매개 변수가 있는 디폴트 생성자");
		x = new_x;
		y = new_y;
	}

	// 메소드 선언문
	public void showPoint() {
		System.out.println(x + ", " + y);
	}
}
