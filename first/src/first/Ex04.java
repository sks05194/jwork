package first;

public class Ex04 {
	public static void add(int a, String op, int b) {
		if (op == "+")
			System.out.println(a + b);
	}

	public static void mul(int a, String op, int b) {
		if (op == "x")
			System.out.println(a * b);
	}

	public static void div(int a, String op, int b) {
		switch (op) {
		case "/":
			System.out.println(a / b);
			break;
		case "%":
			System.out.println(a % b);
			break;
		default:
		}
	}

	public static void sub(int a, String op, int b) {
		if (op == "-")
			System.out.println(a - b);
	}

	public static void calc(int a, String op, int b) {
		switch (op) {
		case "+": System.out.println(a + b); break;
		case "-": System.out.println(a - b); break;
		case "x": System.out.println(a * b); break;
		case "/": System.out.println(a / b); break;
		case "%": System.out.println(a % b); break;
		default:
			System.out.println("지원하지 않는 연산자입니다.");
		}
	}
	
	public static int calcValue(int a, String op, int b) {
		int result = 0;

		switch (op) {
		case "+": result = a + b; break;
		case "-": result = a - b; break;
		case "x": result = a * b; break;
		case "/": result = a / b; break;
		case "%": result = a % b; break;
		default:
			System.out.println("지원하지 않는 연산자입니다.");
		}
		
		return result;
	}

	public static void main(String[] args) {
		add(5, "+", 10);
		mul(5, "x", 10);
		div(10, "/", 5);
		div(10, "%", 5);
		sub(5, "-", 10);

		System.out.println("\n======================\n");

		calc(5, "+", 10);
		calc(5, "x", 10);
		calc(10, "/", 5);
		calc(10, "%", 5);
		calc(5, "-", 10);
		
		System.out.println("\n======================\n");
		
		int result = calcValue(5, "+", 10);
		System.out.println(result);
		
		result = calcValue(5, "x", 10);
		System.out.println(result);
		
		result = calcValue(10, "/", 5);
		System.out.println(result);
		
		result = calcValue(10, "%", 5);
		System.out.println(result);
		
		result = calcValue(5, "-", 10);
		System.out.println(result);

	}
}