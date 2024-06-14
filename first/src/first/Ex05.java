package first;

public class Ex05 {
	public static void main(String[] args) {
		// 삼각형의 면적을 구하는 공식 : 가로 * 세로 / 2
		System.out.printf("삼각형의 면적은 %.2f입니다.\n", area(5, 9, "try")); // 삼각형을 구하는 공식

		// 원의 면적을 구하는 공식 : 반지름 * 반지름 * 원주율(3.14)
		System.out.printf("원의 면적은 %.2f입니다.\n", area(5, 3.14, "cir"));
	}

	public static double area(double a, double b, String shape) {
		double area = 0.0;

		switch (shape) {
		case "try": area = a * b / 2; break;
		case "cir": area = a * a * b; break;
		default:
			System.out.println("도형을 입력해주세요.");
		}

		return area;
	}
}
