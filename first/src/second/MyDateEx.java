package second;

public class MyDateEx {
	public static void main(String[] args) {
		MyDate md = new MyDate(32, 5, 2024);

		// 에러 y 멤버필드는 MyDate 내부에서만 접근 가능한 private 멤버필드인데, MyDateEx 클래스에서 접근하려고 하여 에러 발생
		// md.y = 50; // 에러

		md.isValid();
		System.out.println(md.getMyDate());

		MyDate md1 = new MyDate(32, 5, 2024);
		MyDate md2 = md;
		
		md = new MyDate(32, 5, 2024);
		
		int a = 5;
		int b = 5;
		System.out.println(a == b); // 값 비교
		System.out.println(md == md1); // 주소 비교
		System.out.println(md == md2); // 주소 비교
	}
}
