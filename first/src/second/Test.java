package second;

public class Test {
	int a;
	String s;

	public Test() {
		this(50);
		System.out.println("디폴트생성자");
	}
	public Test(int a) { // 객체생성 형식: Test tt = new Test(10);
		this.a = a;
		System.out.println(a);
	}
	public Test(String s) { // 객체생성 형식: Test tt = new Test("하하하");
		this.s = s;
		System.out.println(s);
	}
	public Test(int a, String s) {
		this.a = a;
		this.s = s;
		System.out.printf("%d, %s %n", a, s);
	}
	public void setPro() {
		a = 5;
		s = "테스트";
	}
	public void setPro(int a) {
		this.a = a;
	}
	public void setPro(int a, String s) {
		this.a = a;
		this.s = s;
	}
}