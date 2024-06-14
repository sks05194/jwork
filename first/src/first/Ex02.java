package first;

public class Ex02 {
	public static void sum(int a, int b) {
		int c = a + b;
		System.out.println("a + b = " + c);
	}

	public static void main(String[] args) {
		int a = 10, b = 20;

		sum(4, 50);
		sum(a, b);
		
		int x = 30, y = 40;
		sum(x, y);
	}
}
