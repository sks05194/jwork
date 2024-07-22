package dbc3;

@SuppressWarnings("static-access")
public class Test {
	private int a = 5;
	private static int b = 7;
	@SuppressWarnings("unused")
	private final int c;

	{
		System.out.println("초기화블록이전의 멤버필드 a의 값: " + this.a + " / b의 값: " + this.b);
		System.out.println("초기화블록");
		this.a = 10;
		this.b = 14;
		this.c = 100;
	}

	static {
		System.out.println("static 초기화블록이전의 멤버필드 b의 값: " + b);
		System.out.println("static 초기화블록");
		b = 21;
	}

	public Test() {
		System.out.println("생성자 블록이전의 멤버필드 a의 값: " + this.a + " / b의 값: " + this.b);
		System.out.println("생성자 블록");
		this.a = 15;
		this.b = 28;
//		this.c = 100;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}
}